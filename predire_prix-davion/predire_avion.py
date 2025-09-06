from flask import Flask, render_template, request
import joblib
import pandas as pd
from sklearn.preprocessing import LabelEncoder
from flask import Flask, render_template, request
import joblib
import pandas as pd

# Initialiser l'app Flask
app = Flask(__name__)

# Charger modèle + encoders
chemin_model = r'C:\Users\User\Desktop\algo_ml\predire_prix-davion\modele_billet.joblib'
pipeline= joblib.load(chemin_model)
# Charger aussi le DataFrame original si nécessaire pour retrouver entreprise et compagnie
chemin_dataframe = r'C:\Users\User\Desktop\algo_ml\predire_prix-davion\Billet_source.csv'
df = pd.read_csv(chemin_dataframe, sep=",")

# ✅ Conversion des dates dans le DataFrame d'origine
df['fk_Date_Depart'] = pd.to_datetime(df['fk_Date_Depart'], dayfirst=True, errors='coerce')
df['fk_Date_Arrivee'] = pd.to_datetime(df['fk_Date_Arrivee'], dayfirst=True, errors='coerce')
df['fk_Date_Depart_str'] = df['fk_Date_Depart'].dt.strftime("%d/%m/%Y")
df['fk_Date_Arrivee_str'] = df['fk_Date_Arrivee'].dt.strftime("%d/%m/%Y")

# Route principale
@app.route('/predire_avion', methods=['GET', 'POST'])
def predire_avion():
    if request.method == 'POST':
        try:
            # Récupérer les données du formulaire
            date_depart = request.form['date_depart']
            date_arrivee = request.form['date_arrivee']
            ville_depart = request.form['ville_depart']
            ville_arrivee = request.form['ville_arrivee']
            classe = request.form['classe']
            bagage = request.form['bagage']

            # Construire DataFrame pour la prédiction
            input_data = pd.DataFrame([{
                'fk_Date_Depart_str': date_depart,
                'fk_Date_Arrivee_str': date_arrivee,
                'fk_ville_depart': ville_depart,
                'fk_ville_Arrivee': ville_arrivee,
                'classe': classe,
                'bagage': bagage
            }])

            # Faire la prédiction
            predicted_price = pipeline.predict(input_data)[0]
            predicted_price = round(predicted_price, 2)

            # Chercher entreprise et compagnie similaire
            match = df[
                (df['fk_ville_depart'] == ville_depart) &
                (df['fk_ville_Arrivee'] == ville_arrivee) &
                (df['classe'] == classe) &
                (df['bagage'] == bagage)
            ]

            entreprise_pred = match['fk_entreprise'].mode().iloc[0] if not match.empty else "N/A"
            compagnie_pred = match['fk_compagnie'].mode().iloc[0] if not match.empty else "N/A"

            return render_template('predire_avion.html',
                                   prix=predicted_price,
                                   entreprise=entreprise_pred,
                                   compagnie=compagnie_pred)

        except Exception as e:
            return render_template('predire_avion.html', error_message=f"Erreur : {str(e)}")

    return render_template('predire_avion.html')

# Lancer l'application
if __name__ == '__main__':
    app.run(debug=True, port=8005)
