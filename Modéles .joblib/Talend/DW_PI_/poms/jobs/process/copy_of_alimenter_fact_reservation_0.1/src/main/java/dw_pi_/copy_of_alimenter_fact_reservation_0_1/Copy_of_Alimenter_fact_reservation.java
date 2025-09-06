// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package dw_pi_.copy_of_alimenter_fact_reservation_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: Copy_of_Alimenter_fact_reservation Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class Copy_of_Alimenter_fact_reservation implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Copy_of_Alimenter_fact_reservation";
	private final String projectName = "DW_PI_";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Copy_of_Alimenter_fact_reservation.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Copy_of_Alimenter_fact_reservation.this,
									new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUnite_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUnite_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row9_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_6_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class nbvcStruct implements routines.system.IPersistableRow<nbvcStruct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];

		public Integer fk_entreprise;

		public Integer getFk_entreprise() {
			return this.fk_entreprise;
		}

		public Integer fk_hotel;

		public Integer getFk_hotel() {
			return this.fk_hotel;
		}

		public String fk_Date;

		public String getFk_Date() {
			return this.fk_Date;
		}

		public String prix_hotel;

		public String getPrix_hotel() {
			return this.prix_hotel;
		}

		public Integer nombre_etoile;

		public Integer getNombre_etoile() {
			return this.nombre_etoile;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.fk_entreprise = readInteger(dis);

					this.fk_hotel = readInteger(dis);

					this.fk_Date = readString(dis);

					this.prix_hotel = readString(dis);

					this.nombre_etoile = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.fk_entreprise = readInteger(dis);

					this.fk_hotel = readInteger(dis);

					this.fk_Date = readString(dis);

					this.prix_hotel = readString(dis);

					this.nombre_etoile = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.fk_entreprise, dos);

				// Integer

				writeInteger(this.fk_hotel, dos);

				// String

				writeString(this.fk_Date, dos);

				// String

				writeString(this.prix_hotel, dos);

				// Integer

				writeInteger(this.nombre_etoile, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.fk_entreprise, dos);

				// Integer

				writeInteger(this.fk_hotel, dos);

				// String

				writeString(this.fk_Date, dos);

				// String

				writeString(this.prix_hotel, dos);

				// Integer

				writeInteger(this.nombre_etoile, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("fk_entreprise=" + String.valueOf(fk_entreprise));
			sb.append(",fk_hotel=" + String.valueOf(fk_hotel));
			sb.append(",fk_Date=" + fk_Date);
			sb.append(",prix_hotel=" + prix_hotel);
			sb.append(",nombre_etoile=" + String.valueOf(nombre_etoile));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(nbvcStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];

		public String name;

		public String getName() {
			return this.name;
		}

		public String price;

		public String getPrice() {
			return this.price;
		}

		public String entreprise;

		public String getEntreprise() {
			return this.entreprise;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.price = readString(dis);

					this.entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.price = readString(dis);

					this.entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.price, dos);

				// String

				writeString(this.entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.price, dos);

				// String

				writeString(this.entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",price=" + price);
			sb.append(",entreprise=" + entreprise);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];

		public String name;

		public String getName() {
			return this.name;
		}

		public String price;

		public String getPrice() {
			return this.price;
		}

		public String entreprise;

		public String getEntreprise() {
			return this.entreprise;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.price = readString(dis);

					this.entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.price = readString(dis);

					this.entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.price, dos);

				// String

				writeString(this.entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.price, dos);

				// String

				writeString(this.entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",price=" + price);
			sb.append(",entreprise=" + entreprise);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];

		public String name;

		public String getName() {
			return this.name;
		}

		public String price;

		public String getPrice() {
			return this.price;
		}

		public String entreprise;

		public String getEntreprise() {
			return this.entreprise;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.price = readString(dis);

					this.entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.price = readString(dis);

					this.entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.price, dos);

				// String

				writeString(this.entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.price, dos);

				// String

				writeString(this.entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",price=" + price);
			sb.append(",entreprise=" + entreprise);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];

		public String name;

		public String getName() {
			return this.name;
		}

		public String price;

		public String getPrice() {
			return this.price;
		}

		public String entreprise;

		public String getEntreprise() {
			return this.entreprise;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.price = readString(dis);

					this.entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.price = readString(dis);

					this.entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.price, dos);

				// String

				writeString(this.entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.price, dos);

				// String

				writeString(this.entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",price=" + price);
			sb.append(",entreprise=" + entreprise);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_4Process(globalMap);
				tDBInput_5Process(globalMap);
				tDBInput_6Process(globalMap);
				tFileInputDelimited_1Process(globalMap);

				row1Struct row1 = new row1Struct();

				row2Struct row2 = new row2Struct();

				row3Struct row3 = new row3Struct();
				nbvcStruct nbvc = new nbvcStruct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "nbvc");
				}

				int tos_count_tDBOutput_1 = 0;

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;
				String dbschema_tDBOutput_1 = null;
				String tableName_tDBOutput_1 = null;
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				long year1_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_1;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_1 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_1 = null;
				String dbUser_tDBOutput_1 = null;
				dbschema_tDBOutput_1 = "";
				String driverClass_tDBOutput_1 = "net.sourceforge.jtds.jdbc.Driver";

				java.lang.Class.forName(driverClass_tDBOutput_1);
				String port_tDBOutput_1 = "1433";
				String dbname_tDBOutput_1 = "DW_PI_BI2";
				String url_tDBOutput_1 = "jdbc:jtds:sqlserver://" + "DESKTOP-02H3Q9I";
				if (!"".equals(port_tDBOutput_1)) {
					url_tDBOutput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_1)) {
					url_tDBOutput_1 += "//" + "DW_PI_BI2";

				}
				url_tDBOutput_1 += ";appName=" + projectName + ";" + "";
				dbUser_tDBOutput_1 = "sa";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:gboVGiqADSlukUGHYxd4VBk9WJQHyOqe4az8B2k8PTb8AL15gIc=");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				int batchSize_tDBOutput_1 = 10000;
				int batchSizeCounter_tDBOutput_1 = 0;

				if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = "fact_Reservation";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "fact_Reservation";
				}
				int count_tDBOutput_1 = 0;

				String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1
						+ "] ([fk_entreprise],[fk_hotel],[fk_Date],[prix_hotel],[nombre_etoile]) VALUES (?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) globalMap
						.get("tHash_Lookup_row4"));

				row4Struct row4HashKey = new row4Struct();
				row4Struct row4Default = new row4Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) globalMap
						.get("tHash_Lookup_row5"));

				row5Struct row5HashKey = new row5Struct();
				row5Struct row5Default = new row5Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) globalMap
						.get("tHash_Lookup_row6"));

				row6Struct row6HashKey = new row6Struct();
				row6Struct row6Default = new row6Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) globalMap
						.get("tHash_Lookup_row9"));

				row9Struct row9HashKey = new row9Struct();
				row9Struct row9Default = new row9Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				nbvcStruct nbvc_tmp = new nbvcStruct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tUnite_1 begin ] start
				 */

				ok_Hash.put("tUnite_1", false);
				start_Hash.put("tUnite_1", System.currentTimeMillis());

				currentComponent = "tUnite_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2", "row1");
				}

				int tos_count_tUnite_1 = 0;

				int nb_line_tUnite_1 = 0;

				/**
				 * [tUnite_1 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_1 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1);
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "sa";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:6B03O0bZBttomDFFL0DSxj3CFyY65ddhSicsAb/JcaJbQNZZN00=");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String port_tDBInput_1 = "1433";
				String dbname_tDBInput_1 = "SA-PI-BI2";
				String url_tDBInput_1 = "jdbc:jtds:sqlserver://" + "DESKTOP-02H3Q9I";
				if (!"".equals(port_tDBInput_1)) {
					url_tDBInput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_1)) {
					url_tDBInput_1 += "//" + "SA-PI-BI2";
				}
				url_tDBInput_1 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_1 = "";

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT \n		touring.name,\n		touring.price,\n		touring.entreprise\nFROM	touring";

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.name = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.name = tmpContent_tDBInput_1;
								}
							} else {
								row1.name = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.price = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.price = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.price = tmpContent_tDBInput_1;
								}
							} else {
								row1.price = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.entreprise = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.entreprise = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.entreprise = tmpContent_tDBInput_1;
								}
							} else {
								row1.entreprise = null;
							}
						}

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tUnite_1 main ] start
						 */

						currentComponent = "tUnite_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

//////////

// for output
						row3 = new row3Struct();

						row3.name = row1.name;
						row3.price = row1.price;
						row3.entreprise = row1.entreprise;

						nb_line_tUnite_1++;

//////////

						tos_count_tUnite_1++;

						/**
						 * [tUnite_1 main ] stop
						 */

						/**
						 * [tUnite_1 process_data_begin ] start
						 */

						currentComponent = "tUnite_1";

						/**
						 * [tUnite_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row3"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						///////////////////////////////////////////////
						// Starting Lookup Table "row4"
						///////////////////////////////////////////////

						boolean forceLooprow4 = false;

						row4Struct row4ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row4HashKey.Hotel_Name = row3.name;

							row4HashKey.hashCodeDirty = true;

							tHash_Lookup_row4.lookup(row4HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4'
							// and it contains more one result from keys : row4.Hotel_Name = '" +
							// row4HashKey.Hotel_Name + "'");
						} // G 071

						row4Struct row4 = null;

						row4Struct fromLookup_row4 = null;
						row4 = row4Default;

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) { // G 099

							fromLookup_row4 = tHash_Lookup_row4.next();

						} // G 099

						if (fromLookup_row4 != null) {
							row4 = fromLookup_row4;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row5"
						///////////////////////////////////////////////

						boolean forceLooprow5 = false;

						row5Struct row5ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row5HashKey.name = row3.name;

							row5HashKey.hashCodeDirty = true;

							tHash_Lookup_row5.lookup(row5HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5'
							// and it contains more one result from keys : row5.name = '" + row5HashKey.name
							// + "'");
						} // G 071

						row5Struct row5 = null;

						row5Struct fromLookup_row5 = null;
						row5 = row5Default;

						if (tHash_Lookup_row5 != null && tHash_Lookup_row5.hasNext()) { // G 099

							fromLookup_row5 = tHash_Lookup_row5.next();

						} // G 099

						if (fromLookup_row5 != null) {
							row5 = fromLookup_row5;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row6"
						///////////////////////////////////////////////

						boolean forceLooprow6 = false;

						row6Struct row6ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row6HashKey.nom_entreprise = row3.entreprise;

							row6HashKey.hashCodeDirty = true;

							tHash_Lookup_row6.lookup(row6HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6'
							// and it contains more one result from keys : row6.nom_entreprise = '" +
							// row6HashKey.nom_entreprise + "'");
						} // G 071

						row6Struct row6 = null;

						row6Struct fromLookup_row6 = null;
						row6 = row6Default;

						if (tHash_Lookup_row6 != null && tHash_Lookup_row6.hasNext()) { // G 099

							fromLookup_row6 = tHash_Lookup_row6.next();

						} // G 099

						if (fromLookup_row6 != null) {
							row6 = fromLookup_row6;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row9"
						///////////////////////////////////////////////

						boolean forceLooprow9 = false;

						row9Struct row9ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row9HashKey.name = row3.name;

							row9HashKey.region = row5.region;

							row9HashKey.hashCodeDirty = true;

							tHash_Lookup_row9.lookup(row9HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row9 != null && tHash_Lookup_row9.getCount(row9HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row9'
							// and it contains more one result from keys : row9.name = '" + row9HashKey.name
							// + "', row9.region = '" + row9HashKey.region + "'");
						} // G 071

						row9Struct row9 = null;

						row9Struct fromLookup_row9 = null;
						row9 = row9Default;

						if (tHash_Lookup_row9 != null && tHash_Lookup_row9.hasNext()) { // G 099

							fromLookup_row9 = tHash_Lookup_row9.next();

						} // G 099

						if (fromLookup_row9 != null) {
							row9 = fromLookup_row9;
						}

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							nbvc = null;

// # Output table : 'nbvc'
							nbvc_tmp.fk_entreprise = row6.id_entreprise;
							nbvc_tmp.fk_hotel = row5.id_hotel;
							nbvc_tmp.fk_Date = row9.date;
							nbvc_tmp.prix_hotel = row3.price;
							nbvc_tmp.nombre_etoile = row4.Number_of_Stars;
							nbvc = nbvc_tmp;
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
// Start of branch "nbvc"
						if (nbvc != null) {

							/**
							 * [tDBOutput_1 main ] start
							 */

							currentComponent = "tDBOutput_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "nbvc"

								);
							}

							whetherReject_tDBOutput_1 = false;
							if (nbvc.fk_entreprise == null) {
								pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_1.setInt(1, nbvc.fk_entreprise);
							}

							if (nbvc.fk_hotel == null) {
								pstmt_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_1.setInt(2, nbvc.fk_hotel);
							}

							if (nbvc.fk_Date == null) {
								pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(3, nbvc.fk_Date);
							}

							if (nbvc.prix_hotel == null) {
								pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(4, nbvc.prix_hotel);
							}

							if (nbvc.nombre_etoile == null) {
								pstmt_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_1.setInt(5, nbvc.nombre_etoile);
							}

							pstmt_tDBOutput_1.addBatch();
							nb_line_tDBOutput_1++;

							batchSizeCounter_tDBOutput_1++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_1 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_1)
										throws Exception {
									try {

										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
												break;
											}
											counter += countEach_tDBOutput_1;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_1 = 0;
										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_1)
										throws Exception {
									try {

										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
												break;
											}
											counter += countEach_tDBOutput_1;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_1 > 0)
									&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {

								insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
										.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);
								rowsToCommitCount_tDBOutput_1 = insertedCount_tDBOutput_1;

								batchSizeCounter_tDBOutput_1 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_1++;
							if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
								if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {

									insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
											.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);

									batchSizeCounter_tDBOutput_1 = 0;
								}
								if (rowsToCommitCount_tDBOutput_1 != 0) {

								}
								conn_tDBOutput_1.commit();
								if (rowsToCommitCount_tDBOutput_1 != 0) {

									rowsToCommitCount_tDBOutput_1 = 0;
								}
								commitCounter_tDBOutput_1 = 0;
							}

							tos_count_tDBOutput_1++;

							/**
							 * [tDBOutput_1 main ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_end ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_end ] stop
							 */

						} // End of branch "nbvc"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tUnite_1 process_data_end ] start
						 */

						currentComponent = "tUnite_1";

						/**
						 * [tUnite_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_2 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_2 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_2 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_2, talendToDBArray_tDBInput_2);
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "sa";

				final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:GXDR/d83eFqcUNnzvN7PTqDOHxNH+9naVVbRM1p6uuK0UkWoW4g=");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String port_tDBInput_2 = "1433";
				String dbname_tDBInput_2 = "SA-PI-BI2";
				String url_tDBInput_2 = "jdbc:jtds:sqlserver://" + "DESKTOP-02H3Q9I";
				if (!"".equals(port_tDBInput_2)) {
					url_tDBInput_2 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_2)) {
					url_tDBInput_2 += "//" + "SA-PI-BI2";
				}
				url_tDBInput_2 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_2 = "";

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT \n		traveltodo.name,\n		traveltodo.price,\n		traveltodo.entreprise\nFROM	traveltodo";

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row2.name = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(1);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.name = tmpContent_tDBInput_2;
								}
							} else {
								row2.name = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row2.price = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.price = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.price = tmpContent_tDBInput_2;
								}
							} else {
								row2.price = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row2.entreprise = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.entreprise = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.entreprise = tmpContent_tDBInput_2;
								}
							} else {
								row2.entreprise = null;
							}
						}

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tUnite_1 main ] start
						 */

						currentComponent = "tUnite_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row2"

							);
						}

//////////

// for output
						row3 = new row3Struct();

						row3.name = row2.name;
						row3.price = row2.price;
						row3.entreprise = row2.entreprise;

						nb_line_tUnite_1++;

//////////

						tos_count_tUnite_1++;

						/**
						 * [tUnite_1 main ] stop
						 */

						/**
						 * [tUnite_1 process_data_begin ] start
						 */

						currentComponent = "tUnite_1";

						/**
						 * [tUnite_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row3"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						///////////////////////////////////////////////
						// Starting Lookup Table "row4"
						///////////////////////////////////////////////

						boolean forceLooprow4 = false;

						row4Struct row4ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row4HashKey.Hotel_Name = row3.name;

							row4HashKey.hashCodeDirty = true;

							tHash_Lookup_row4.lookup(row4HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4'
							// and it contains more one result from keys : row4.Hotel_Name = '" +
							// row4HashKey.Hotel_Name + "'");
						} // G 071

						row4Struct row4 = null;

						row4Struct fromLookup_row4 = null;
						row4 = row4Default;

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) { // G 099

							fromLookup_row4 = tHash_Lookup_row4.next();

						} // G 099

						if (fromLookup_row4 != null) {
							row4 = fromLookup_row4;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row5"
						///////////////////////////////////////////////

						boolean forceLooprow5 = false;

						row5Struct row5ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row5HashKey.name = row3.name;

							row5HashKey.hashCodeDirty = true;

							tHash_Lookup_row5.lookup(row5HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5'
							// and it contains more one result from keys : row5.name = '" + row5HashKey.name
							// + "'");
						} // G 071

						row5Struct row5 = null;

						row5Struct fromLookup_row5 = null;
						row5 = row5Default;

						if (tHash_Lookup_row5 != null && tHash_Lookup_row5.hasNext()) { // G 099

							fromLookup_row5 = tHash_Lookup_row5.next();

						} // G 099

						if (fromLookup_row5 != null) {
							row5 = fromLookup_row5;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row6"
						///////////////////////////////////////////////

						boolean forceLooprow6 = false;

						row6Struct row6ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row6HashKey.nom_entreprise = row3.entreprise;

							row6HashKey.hashCodeDirty = true;

							tHash_Lookup_row6.lookup(row6HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6'
							// and it contains more one result from keys : row6.nom_entreprise = '" +
							// row6HashKey.nom_entreprise + "'");
						} // G 071

						row6Struct row6 = null;

						row6Struct fromLookup_row6 = null;
						row6 = row6Default;

						if (tHash_Lookup_row6 != null && tHash_Lookup_row6.hasNext()) { // G 099

							fromLookup_row6 = tHash_Lookup_row6.next();

						} // G 099

						if (fromLookup_row6 != null) {
							row6 = fromLookup_row6;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row9"
						///////////////////////////////////////////////

						boolean forceLooprow9 = false;

						row9Struct row9ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row9HashKey.name = row3.name;

							row9HashKey.region = row5.region;

							row9HashKey.hashCodeDirty = true;

							tHash_Lookup_row9.lookup(row9HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row9 != null && tHash_Lookup_row9.getCount(row9HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row9'
							// and it contains more one result from keys : row9.name = '" + row9HashKey.name
							// + "', row9.region = '" + row9HashKey.region + "'");
						} // G 071

						row9Struct row9 = null;

						row9Struct fromLookup_row9 = null;
						row9 = row9Default;

						if (tHash_Lookup_row9 != null && tHash_Lookup_row9.hasNext()) { // G 099

							fromLookup_row9 = tHash_Lookup_row9.next();

						} // G 099

						if (fromLookup_row9 != null) {
							row9 = fromLookup_row9;
						}

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							nbvc = null;

// # Output table : 'nbvc'
							nbvc_tmp.fk_entreprise = row6.id_entreprise;
							nbvc_tmp.fk_hotel = row5.id_hotel;
							nbvc_tmp.fk_Date = row9.date;
							nbvc_tmp.prix_hotel = row3.price;
							nbvc_tmp.nombre_etoile = row4.Number_of_Stars;
							nbvc = nbvc_tmp;
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
// Start of branch "nbvc"
						if (nbvc != null) {

							/**
							 * [tDBOutput_1 main ] start
							 */

							currentComponent = "tDBOutput_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "nbvc"

								);
							}

							whetherReject_tDBOutput_1 = false;
							if (nbvc.fk_entreprise == null) {
								pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_1.setInt(1, nbvc.fk_entreprise);
							}

							if (nbvc.fk_hotel == null) {
								pstmt_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_1.setInt(2, nbvc.fk_hotel);
							}

							if (nbvc.fk_Date == null) {
								pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(3, nbvc.fk_Date);
							}

							if (nbvc.prix_hotel == null) {
								pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(4, nbvc.prix_hotel);
							}

							if (nbvc.nombre_etoile == null) {
								pstmt_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_1.setInt(5, nbvc.nombre_etoile);
							}

							pstmt_tDBOutput_1.addBatch();
							nb_line_tDBOutput_1++;

							batchSizeCounter_tDBOutput_1++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_1 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_1)
										throws Exception {
									try {

										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
												break;
											}
											counter += countEach_tDBOutput_1;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_1 = 0;
										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_1)
										throws Exception {
									try {

										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
												break;
											}
											counter += countEach_tDBOutput_1;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_1 > 0)
									&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {

								insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
										.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);
								rowsToCommitCount_tDBOutput_1 = insertedCount_tDBOutput_1;

								batchSizeCounter_tDBOutput_1 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_1++;
							if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
								if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {

									insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
											.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);

									batchSizeCounter_tDBOutput_1 = 0;
								}
								if (rowsToCommitCount_tDBOutput_1 != 0) {

								}
								conn_tDBOutput_1.commit();
								if (rowsToCommitCount_tDBOutput_1 != 0) {

									rowsToCommitCount_tDBOutput_1 = 0;
								}
								commitCounter_tDBOutput_1 = 0;
							}

							tos_count_tDBOutput_1++;

							/**
							 * [tDBOutput_1 main ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_end ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_end ] stop
							 */

						} // End of branch "nbvc"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tUnite_1 process_data_end ] start
						 */

						currentComponent = "tUnite_1";

						/**
						 * [tUnite_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tUnite_1 end ] start
				 */

				currentComponent = "tUnite_1";

				globalMap.put("tUnite_1_NB_LINE", nb_line_tUnite_1);
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2", "row1");
				}

				ok_Hash.put("tUnite_1", true);
				end_Hash.put("tUnite_1", System.currentTimeMillis());

				/**
				 * [tUnite_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row4 != null) {
					tHash_Lookup_row4.endGet();
				}
				globalMap.remove("tHash_Lookup_row4");

				if (tHash_Lookup_row5 != null) {
					tHash_Lookup_row5.endGet();
				}
				globalMap.remove("tHash_Lookup_row5");

				if (tHash_Lookup_row6 != null) {
					tHash_Lookup_row6.endGet();
				}
				globalMap.remove("tHash_Lookup_row6");

				if (tHash_Lookup_row9 != null) {
					tHash_Lookup_row9.endGet();
				}
				globalMap.remove("tHash_Lookup_row9");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					int countSum_tDBOutput_1 = 0;
					if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {

						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							countSum_tDBOutput_1 += countEach_tDBOutput_1;
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					}

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");

				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (rowsToCommitCount_tDBOutput_1 != 0) {

				}
				conn_tDBOutput_1.commit();
				if (rowsToCommitCount_tDBOutput_1 != 0) {

					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;
				conn_tDBOutput_1.close();
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "nbvc");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row5");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row6");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row9");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row4");

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tUnite_1 finally ] start
				 */

				currentComponent = "tUnite_1";

				/**
				 * [tUnite_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								ctn_tDBOutput_1.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row5Struct implements routines.system.IPersistableComparableLookupRow<row5Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id_hotel;

		public int getId_hotel() {
			return this.id_hotel;
		}

		public String name;

		public String getName() {
			return this.name;
		}

		public String region;

		public String getRegion() {
			return this.region;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row5Struct other = (row5Struct) obj;

			if (this.name == null) {
				if (other.name != null)
					return false;

			} else if (!this.name.equals(other.name))

				return false;

			return true;
		}

		public void copyDataTo(row5Struct other) {

			other.id_hotel = this.id_hotel;
			other.name = this.name;
			other.region = this.region;

		}

		public void copyKeysDataTo(row5Struct other) {

			other.name = this.name;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.id_hotel = dis.readInt();

				this.region = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.id_hotel = objectIn.readInt();

				this.region = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.id_hotel);

				writeString(this.region, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.id_hotel);

				writeString(this.region, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id_hotel=" + String.valueOf(id_hotel));
			sb.append(",name=" + name);
			sb.append(",region=" + region);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.name, other.name);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row5Struct row5 = new row5Struct();

				/**
				 * [tAdvancedHash_row5 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row5", false);
				start_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tAdvancedHash_row5 = 0;

				// connection name:row5
				// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(row5,row5) |
				// target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
				// linked node: tMap_1 - inputs:(row3,row5,row6,row9,row4) outputs:(nbvc)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row5Struct>getLookup(matchingModeEnum_row5);

				globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);

				/**
				 * [tAdvancedHash_row5 begin ] stop
				 */

				/**
				 * [tDBInput_4 begin ] start
				 */

				ok_Hash.put("tDBInput_4", false);
				start_Hash.put("tDBInput_4", System.currentTimeMillis());

				currentComponent = "tDBInput_4";

				int tos_count_tDBInput_4 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_4 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_4 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_4 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_4, talendToDBArray_tDBInput_4);
				int nb_line_tDBInput_4 = 0;
				java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = "sa";

				final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:9jyiE5joBR+rgjV0plIeMQK+tSi806YKZRHb5t+yZx7aqnbl4rk=");

				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;

				String port_tDBInput_4 = "1433";
				String dbname_tDBInput_4 = "DW_PI_BI2";
				String url_tDBInput_4 = "jdbc:jtds:sqlserver://" + "DESKTOP-02H3Q9I";
				if (!"".equals(port_tDBInput_4)) {
					url_tDBInput_4 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_4)) {
					url_tDBInput_4 += "//" + "DW_PI_BI2";
				}
				url_tDBInput_4 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_4 = "";

				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4, dbUser_tDBInput_4,
						dbPwd_tDBInput_4);

				java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

				String dbquery_tDBInput_4 = "SELECT Dim_hotel.id_hotel,\n		Dim_hotel.name,\n		Dim_hotel.region\nFROM	Dim_hotel";

				globalMap.put("tDBInput_4_QUERY", dbquery_tDBInput_4);
				java.sql.ResultSet rs_tDBInput_4 = null;

				try {
					rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
					java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
					int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

					String tmpContent_tDBInput_4 = null;

					while (rs_tDBInput_4.next()) {
						nb_line_tDBInput_4++;

						if (colQtyInRs_tDBInput_4 < 1) {
							row5.id_hotel = 0;
						} else {

							row5.id_hotel = rs_tDBInput_4.getInt(1);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 2) {
							row5.name = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(2);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row5.name = tmpContent_tDBInput_4;
								}
							} else {
								row5.name = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 3) {
							row5.region = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(3);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.region = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row5.region = tmpContent_tDBInput_4;
								}
							} else {
								row5.region = null;
							}
						}

						/**
						 * [tDBInput_4 begin ] stop
						 */

						/**
						 * [tDBInput_4 main ] start
						 */

						currentComponent = "tDBInput_4";

						tos_count_tDBInput_4++;

						/**
						 * [tDBInput_4 main ] stop
						 */

						/**
						 * [tDBInput_4 process_data_begin ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row5 main ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row5"

							);
						}

						row5Struct row5_HashRow = new row5Struct();

						row5_HashRow.id_hotel = row5.id_hotel;

						row5_HashRow.name = row5.name;

						row5_HashRow.region = row5.region;

						tHash_Lookup_row5.put(row5_HashRow);

						tos_count_tAdvancedHash_row5++;

						/**
						 * [tAdvancedHash_row5 main ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 process_data_end ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 end ] start
						 */

						currentComponent = "tDBInput_4";

					}
				} finally {
					if (rs_tDBInput_4 != null) {
						rs_tDBInput_4.close();
					}
					if (stmt_tDBInput_4 != null) {
						stmt_tDBInput_4.close();
					}
					if (conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {

						conn_tDBInput_4.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_4_NB_LINE", nb_line_tDBInput_4);

				ok_Hash.put("tDBInput_4", true);
				end_Hash.put("tDBInput_4", System.currentTimeMillis());

				/**
				 * [tDBInput_4 end ] stop
				 */

				/**
				 * [tAdvancedHash_row5 end ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				tHash_Lookup_row5.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				ok_Hash.put("tAdvancedHash_row5", true);
				end_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row5 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_4 finally ] start
				 */

				currentComponent = "tDBInput_4";

				/**
				 * [tDBInput_4 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row5 finally ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				/**
				 * [tAdvancedHash_row5 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}

	public static class row6Struct implements routines.system.IPersistableComparableLookupRow<row6Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id_entreprise;

		public int getId_entreprise() {
			return this.id_entreprise;
		}

		public String nom_entreprise;

		public String getNom_entreprise() {
			return this.nom_entreprise;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.nom_entreprise == null) ? 0 : this.nom_entreprise.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row6Struct other = (row6Struct) obj;

			if (this.nom_entreprise == null) {
				if (other.nom_entreprise != null)
					return false;

			} else if (!this.nom_entreprise.equals(other.nom_entreprise))

				return false;

			return true;
		}

		public void copyDataTo(row6Struct other) {

			other.id_entreprise = this.id_entreprise;
			other.nom_entreprise = this.nom_entreprise;

		}

		public void copyKeysDataTo(row6Struct other) {

			other.nom_entreprise = this.nom_entreprise;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.nom_entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.nom_entreprise = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nom_entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nom_entreprise, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.id_entreprise = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.id_entreprise = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.id_entreprise);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.id_entreprise);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id_entreprise=" + String.valueOf(id_entreprise));
			sb.append(",nom_entreprise=" + nom_entreprise);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.nom_entreprise, other.nom_entreprise);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row6Struct row6 = new row6Struct();

				/**
				 * [tAdvancedHash_row6 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row6", false);
				start_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row6";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tAdvancedHash_row6 = 0;

				// connection name:row6
				// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(row6,row6) |
				// target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
				// linked node: tMap_1 - inputs:(row3,row5,row6,row9,row4) outputs:(nbvc)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row6 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row6Struct>getLookup(matchingModeEnum_row6);

				globalMap.put("tHash_Lookup_row6", tHash_Lookup_row6);

				/**
				 * [tAdvancedHash_row6 begin ] stop
				 */

				/**
				 * [tDBInput_5 begin ] start
				 */

				ok_Hash.put("tDBInput_5", false);
				start_Hash.put("tDBInput_5", System.currentTimeMillis());

				currentComponent = "tDBInput_5";

				int tos_count_tDBInput_5 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_5 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_5 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_5 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_5, talendToDBArray_tDBInput_5);
				int nb_line_tDBInput_5 = 0;
				java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = "sa";

				final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:ck7msTmVQZ1Imrw0AED3Q3evlmdcPqlUyZ4GzaP90I33HbR/P6Q=");

				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;

				String port_tDBInput_5 = "1433";
				String dbname_tDBInput_5 = "DW_PI_BI2";
				String url_tDBInput_5 = "jdbc:jtds:sqlserver://" + "DESKTOP-02H3Q9I";
				if (!"".equals(port_tDBInput_5)) {
					url_tDBInput_5 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_5)) {
					url_tDBInput_5 += "//" + "DW_PI_BI2";
				}
				url_tDBInput_5 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_5 = "";

				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5, dbUser_tDBInput_5,
						dbPwd_tDBInput_5);

				java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

				String dbquery_tDBInput_5 = "SELECT dim_entreprise.id_entreprise,\n		dim_entreprise.nom_entreprise\nFROM	dim_entreprise";

				globalMap.put("tDBInput_5_QUERY", dbquery_tDBInput_5);
				java.sql.ResultSet rs_tDBInput_5 = null;

				try {
					rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
					java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
					int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

					String tmpContent_tDBInput_5 = null;

					while (rs_tDBInput_5.next()) {
						nb_line_tDBInput_5++;

						if (colQtyInRs_tDBInput_5 < 1) {
							row6.id_entreprise = 0;
						} else {

							row6.id_entreprise = rs_tDBInput_5.getInt(1);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_5 < 2) {
							row6.nom_entreprise = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(2);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row6.nom_entreprise = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row6.nom_entreprise = tmpContent_tDBInput_5;
								}
							} else {
								row6.nom_entreprise = null;
							}
						}

						/**
						 * [tDBInput_5 begin ] stop
						 */

						/**
						 * [tDBInput_5 main ] start
						 */

						currentComponent = "tDBInput_5";

						tos_count_tDBInput_5++;

						/**
						 * [tDBInput_5 main ] stop
						 */

						/**
						 * [tDBInput_5 process_data_begin ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row6 main ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row6"

							);
						}

						row6Struct row6_HashRow = new row6Struct();

						row6_HashRow.id_entreprise = row6.id_entreprise;

						row6_HashRow.nom_entreprise = row6.nom_entreprise;

						tHash_Lookup_row6.put(row6_HashRow);

						tos_count_tAdvancedHash_row6++;

						/**
						 * [tAdvancedHash_row6 main ] stop
						 */

						/**
						 * [tAdvancedHash_row6 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						/**
						 * [tAdvancedHash_row6 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row6 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						/**
						 * [tAdvancedHash_row6 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 process_data_end ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 end ] start
						 */

						currentComponent = "tDBInput_5";

					}
				} finally {
					if (rs_tDBInput_5 != null) {
						rs_tDBInput_5.close();
					}
					if (stmt_tDBInput_5 != null) {
						stmt_tDBInput_5.close();
					}
					if (conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {

						conn_tDBInput_5.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_5_NB_LINE", nb_line_tDBInput_5);

				ok_Hash.put("tDBInput_5", true);
				end_Hash.put("tDBInput_5", System.currentTimeMillis());

				/**
				 * [tDBInput_5 end ] stop
				 */

				/**
				 * [tAdvancedHash_row6 end ] start
				 */

				currentComponent = "tAdvancedHash_row6";

				tHash_Lookup_row6.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
				}

				ok_Hash.put("tAdvancedHash_row6", true);
				end_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row6 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_5 finally ] start
				 */

				currentComponent = "tDBInput_5";

				/**
				 * [tDBInput_5 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row6 finally ] start
				 */

				currentComponent = "tAdvancedHash_row6";

				/**
				 * [tAdvancedHash_row6 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}

	public static class row9Struct implements routines.system.IPersistableComparableLookupRow<row9Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String name;

		public String getName() {
			return this.name;
		}

		public String region;

		public String getRegion() {
			return this.region;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());

				result = prime * result + ((this.region == null) ? 0 : this.region.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row9Struct other = (row9Struct) obj;

			if (this.name == null) {
				if (other.name != null)
					return false;

			} else if (!this.name.equals(other.name))

				return false;

			if (this.region == null) {
				if (other.region != null)
					return false;

			} else if (!this.region.equals(other.region))

				return false;

			return true;
		}

		public void copyDataTo(row9Struct other) {

			other.name = this.name;
			other.region = this.region;
			other.date = this.date;

		}

		public void copyKeysDataTo(row9Struct other) {

			other.name = this.name;
			other.region = this.region;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.region = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.region = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.region, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.region, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.date = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.date = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.date, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.date, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",region=" + region);
			sb.append(",date=" + date);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row9Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.name, other.name);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.region, other.region);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];

		public String name;

		public String getName() {
			return this.name;
		}

		public String region;

		public String getRegion() {
			return this.region;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.region = readString(dis);

					this.date = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.region = readString(dis);

					this.date = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",region=" + region);
			sb.append(",date=" + date);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row7Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row8Struct implements routines.system.IPersistableRow<row8Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];

		public String name;

		public String getName() {
			return this.name;
		}

		public String region;

		public String getRegion() {
			return this.region;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.region = readString(dis);

					this.date = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.name = readString(dis);

					this.region = readString(dis);

					this.date = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.name, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",region=" + region);
			sb.append(",date=" + date);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row8Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_6_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row7Struct row7 = new row7Struct();

				row8Struct row8 = new row8Struct();

				row9Struct row9 = new row9Struct();

				/**
				 * [tAdvancedHash_row9 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row9", false);
				start_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row9";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row9");
				}

				int tos_count_tAdvancedHash_row9 = 0;

				// connection name:row9
				// source node:tUnite_2 - inputs:(row7,row8) outputs:(row9,row9) | target
				// node:tAdvancedHash_row9 - inputs:(row9) outputs:()
				// linked node: tMap_1 - inputs:(row3,row5,row6,row9,row4) outputs:(nbvc)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row9 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row9Struct>getLookup(matchingModeEnum_row9);

				globalMap.put("tHash_Lookup_row9", tHash_Lookup_row9);

				/**
				 * [tAdvancedHash_row9 begin ] stop
				 */

				/**
				 * [tUnite_2 begin ] start
				 */

				ok_Hash.put("tUnite_2", false);
				start_Hash.put("tUnite_2", System.currentTimeMillis());

				currentComponent = "tUnite_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row8", "row7");
				}

				int tos_count_tUnite_2 = 0;

				int nb_line_tUnite_2 = 0;

				/**
				 * [tUnite_2 begin ] stop
				 */

				/**
				 * [tDBInput_6 begin ] start
				 */

				ok_Hash.put("tDBInput_6", false);
				start_Hash.put("tDBInput_6", System.currentTimeMillis());

				currentComponent = "tDBInput_6";

				int tos_count_tDBInput_6 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_6 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_6 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_6 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_6, talendToDBArray_tDBInput_6);
				int nb_line_tDBInput_6 = 0;
				java.sql.Connection conn_tDBInput_6 = null;
				String driverClass_tDBInput_6 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_6 = java.lang.Class.forName(driverClass_tDBInput_6);
				String dbUser_tDBInput_6 = "sa";

				final String decryptedPassword_tDBInput_6 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:OhNqmfZooKqf04EivFYoAEZRBkkm2PxFj+GUpbyppVO2mxcvkBo=");

				String dbPwd_tDBInput_6 = decryptedPassword_tDBInput_6;

				String port_tDBInput_6 = "1433";
				String dbname_tDBInput_6 = "SA-PI-BI2";
				String url_tDBInput_6 = "jdbc:jtds:sqlserver://" + "DESKTOP-02H3Q9I";
				if (!"".equals(port_tDBInput_6)) {
					url_tDBInput_6 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_6)) {
					url_tDBInput_6 += "//" + "SA-PI-BI2";
				}
				url_tDBInput_6 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_6 = "";

				conn_tDBInput_6 = java.sql.DriverManager.getConnection(url_tDBInput_6, dbUser_tDBInput_6,
						dbPwd_tDBInput_6);

				java.sql.Statement stmt_tDBInput_6 = conn_tDBInput_6.createStatement();

				String dbquery_tDBInput_6 = "SELECT \n		touring_external_dates.name,\n		touring_external_dates.region,\n		touring_external_dates.date\nFROM	touring_exte"
						+ "rnal_dates";

				globalMap.put("tDBInput_6_QUERY", dbquery_tDBInput_6);
				java.sql.ResultSet rs_tDBInput_6 = null;

				try {
					rs_tDBInput_6 = stmt_tDBInput_6.executeQuery(dbquery_tDBInput_6);
					java.sql.ResultSetMetaData rsmd_tDBInput_6 = rs_tDBInput_6.getMetaData();
					int colQtyInRs_tDBInput_6 = rsmd_tDBInput_6.getColumnCount();

					String tmpContent_tDBInput_6 = null;

					while (rs_tDBInput_6.next()) {
						nb_line_tDBInput_6++;

						if (colQtyInRs_tDBInput_6 < 1) {
							row7.name = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(1);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row7.name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row7.name = tmpContent_tDBInput_6;
								}
							} else {
								row7.name = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 2) {
							row7.region = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(2);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row7.region = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row7.region = tmpContent_tDBInput_6;
								}
							} else {
								row7.region = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 3) {
							row7.date = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(3);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row7.date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row7.date = tmpContent_tDBInput_6;
								}
							} else {
								row7.date = null;
							}
						}

						/**
						 * [tDBInput_6 begin ] stop
						 */

						/**
						 * [tDBInput_6 main ] start
						 */

						currentComponent = "tDBInput_6";

						tos_count_tDBInput_6++;

						/**
						 * [tDBInput_6 main ] stop
						 */

						/**
						 * [tDBInput_6 process_data_begin ] start
						 */

						currentComponent = "tDBInput_6";

						/**
						 * [tDBInput_6 process_data_begin ] stop
						 */

						/**
						 * [tUnite_2 main ] start
						 */

						currentComponent = "tUnite_2";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row7"

							);
						}

//////////

// for output
						row9 = new row9Struct();

						row9.name = row7.name;
						row9.region = row7.region;
						row9.date = row7.date;

						nb_line_tUnite_2++;

//////////

						tos_count_tUnite_2++;

						/**
						 * [tUnite_2 main ] stop
						 */

						/**
						 * [tUnite_2 process_data_begin ] start
						 */

						currentComponent = "tUnite_2";

						/**
						 * [tUnite_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row9 main ] start
						 */

						currentComponent = "tAdvancedHash_row9";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row9"

							);
						}

						row9Struct row9_HashRow = new row9Struct();

						row9_HashRow.name = row9.name;

						row9_HashRow.region = row9.region;

						row9_HashRow.date = row9.date;

						tHash_Lookup_row9.put(row9_HashRow);

						tos_count_tAdvancedHash_row9++;

						/**
						 * [tAdvancedHash_row9 main ] stop
						 */

						/**
						 * [tAdvancedHash_row9 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row9";

						/**
						 * [tAdvancedHash_row9 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row9 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row9";

						/**
						 * [tAdvancedHash_row9 process_data_end ] stop
						 */

						/**
						 * [tUnite_2 process_data_end ] start
						 */

						currentComponent = "tUnite_2";

						/**
						 * [tUnite_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_6 process_data_end ] start
						 */

						currentComponent = "tDBInput_6";

						/**
						 * [tDBInput_6 process_data_end ] stop
						 */

						/**
						 * [tDBInput_6 end ] start
						 */

						currentComponent = "tDBInput_6";

					}
				} finally {
					if (rs_tDBInput_6 != null) {
						rs_tDBInput_6.close();
					}
					if (stmt_tDBInput_6 != null) {
						stmt_tDBInput_6.close();
					}
					if (conn_tDBInput_6 != null && !conn_tDBInput_6.isClosed()) {

						conn_tDBInput_6.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_6_NB_LINE", nb_line_tDBInput_6);

				ok_Hash.put("tDBInput_6", true);
				end_Hash.put("tDBInput_6", System.currentTimeMillis());

				/**
				 * [tDBInput_6 end ] stop
				 */

				/**
				 * [tDBInput_7 begin ] start
				 */

				ok_Hash.put("tDBInput_7", false);
				start_Hash.put("tDBInput_7", System.currentTimeMillis());

				currentComponent = "tDBInput_7";

				int tos_count_tDBInput_7 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_7 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_7 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_7 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_7, talendToDBArray_tDBInput_7);
				int nb_line_tDBInput_7 = 0;
				java.sql.Connection conn_tDBInput_7 = null;
				String driverClass_tDBInput_7 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_7 = java.lang.Class.forName(driverClass_tDBInput_7);
				String dbUser_tDBInput_7 = "sa";

				final String decryptedPassword_tDBInput_7 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:eiEhLBImgjLSo/+bxwS215K8HW2JWhdA46QhaycfacKdK79dWBY=");

				String dbPwd_tDBInput_7 = decryptedPassword_tDBInput_7;

				String port_tDBInput_7 = "1433";
				String dbname_tDBInput_7 = "SA-PI-BI2";
				String url_tDBInput_7 = "jdbc:jtds:sqlserver://" + "DESKTOP-02H3Q9I";
				if (!"".equals(port_tDBInput_7)) {
					url_tDBInput_7 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_7)) {
					url_tDBInput_7 += "//" + "SA-PI-BI2";
				}
				url_tDBInput_7 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_7 = "";

				conn_tDBInput_7 = java.sql.DriverManager.getConnection(url_tDBInput_7, dbUser_tDBInput_7,
						dbPwd_tDBInput_7);

				java.sql.Statement stmt_tDBInput_7 = conn_tDBInput_7.createStatement();

				String dbquery_tDBInput_7 = "SELECT \n		traveltodo_external_dates.name,\n		traveltodo_external_dates.region,\n		traveltodo_external_dates.date\nFROM	tra"
						+ "veltodo_external_dates";

				globalMap.put("tDBInput_7_QUERY", dbquery_tDBInput_7);
				java.sql.ResultSet rs_tDBInput_7 = null;

				try {
					rs_tDBInput_7 = stmt_tDBInput_7.executeQuery(dbquery_tDBInput_7);
					java.sql.ResultSetMetaData rsmd_tDBInput_7 = rs_tDBInput_7.getMetaData();
					int colQtyInRs_tDBInput_7 = rsmd_tDBInput_7.getColumnCount();

					String tmpContent_tDBInput_7 = null;

					while (rs_tDBInput_7.next()) {
						nb_line_tDBInput_7++;

						if (colQtyInRs_tDBInput_7 < 1) {
							row8.name = null;
						} else {

							tmpContent_tDBInput_7 = rs_tDBInput_7.getString(1);
							if (tmpContent_tDBInput_7 != null) {
								if (talendToDBList_tDBInput_7.contains(
										rsmd_tDBInput_7.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row8.name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_7);
								} else {
									row8.name = tmpContent_tDBInput_7;
								}
							} else {
								row8.name = null;
							}
						}
						if (colQtyInRs_tDBInput_7 < 2) {
							row8.region = null;
						} else {

							tmpContent_tDBInput_7 = rs_tDBInput_7.getString(2);
							if (tmpContent_tDBInput_7 != null) {
								if (talendToDBList_tDBInput_7.contains(
										rsmd_tDBInput_7.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row8.region = FormatterUtils.formatUnwithE(tmpContent_tDBInput_7);
								} else {
									row8.region = tmpContent_tDBInput_7;
								}
							} else {
								row8.region = null;
							}
						}
						if (colQtyInRs_tDBInput_7 < 3) {
							row8.date = null;
						} else {

							tmpContent_tDBInput_7 = rs_tDBInput_7.getString(3);
							if (tmpContent_tDBInput_7 != null) {
								if (talendToDBList_tDBInput_7.contains(
										rsmd_tDBInput_7.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row8.date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_7);
								} else {
									row8.date = tmpContent_tDBInput_7;
								}
							} else {
								row8.date = null;
							}
						}

						/**
						 * [tDBInput_7 begin ] stop
						 */

						/**
						 * [tDBInput_7 main ] start
						 */

						currentComponent = "tDBInput_7";

						tos_count_tDBInput_7++;

						/**
						 * [tDBInput_7 main ] stop
						 */

						/**
						 * [tDBInput_7 process_data_begin ] start
						 */

						currentComponent = "tDBInput_7";

						/**
						 * [tDBInput_7 process_data_begin ] stop
						 */

						/**
						 * [tUnite_2 main ] start
						 */

						currentComponent = "tUnite_2";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row8"

							);
						}

//////////

// for output
						row9 = new row9Struct();

						row9.name = row8.name;
						row9.region = row8.region;
						row9.date = row8.date;

						nb_line_tUnite_2++;

//////////

						tos_count_tUnite_2++;

						/**
						 * [tUnite_2 main ] stop
						 */

						/**
						 * [tUnite_2 process_data_begin ] start
						 */

						currentComponent = "tUnite_2";

						/**
						 * [tUnite_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row9 main ] start
						 */

						currentComponent = "tAdvancedHash_row9";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row9"

							);
						}

						row9Struct row9_HashRow = new row9Struct();

						row9_HashRow.name = row9.name;

						row9_HashRow.region = row9.region;

						row9_HashRow.date = row9.date;

						tHash_Lookup_row9.put(row9_HashRow);

						tos_count_tAdvancedHash_row9++;

						/**
						 * [tAdvancedHash_row9 main ] stop
						 */

						/**
						 * [tAdvancedHash_row9 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row9";

						/**
						 * [tAdvancedHash_row9 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row9 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row9";

						/**
						 * [tAdvancedHash_row9 process_data_end ] stop
						 */

						/**
						 * [tUnite_2 process_data_end ] start
						 */

						currentComponent = "tUnite_2";

						/**
						 * [tUnite_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_7 process_data_end ] start
						 */

						currentComponent = "tDBInput_7";

						/**
						 * [tDBInput_7 process_data_end ] stop
						 */

						/**
						 * [tDBInput_7 end ] start
						 */

						currentComponent = "tDBInput_7";

					}
				} finally {
					if (rs_tDBInput_7 != null) {
						rs_tDBInput_7.close();
					}
					if (stmt_tDBInput_7 != null) {
						stmt_tDBInput_7.close();
					}
					if (conn_tDBInput_7 != null && !conn_tDBInput_7.isClosed()) {

						conn_tDBInput_7.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_7_NB_LINE", nb_line_tDBInput_7);

				ok_Hash.put("tDBInput_7", true);
				end_Hash.put("tDBInput_7", System.currentTimeMillis());

				/**
				 * [tDBInput_7 end ] stop
				 */

				/**
				 * [tUnite_2 end ] start
				 */

				currentComponent = "tUnite_2";

				globalMap.put("tUnite_2_NB_LINE", nb_line_tUnite_2);
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row8", "row7");
				}

				ok_Hash.put("tUnite_2", true);
				end_Hash.put("tUnite_2", System.currentTimeMillis());

				/**
				 * [tUnite_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_row9 end ] start
				 */

				currentComponent = "tAdvancedHash_row9";

				tHash_Lookup_row9.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row9");
				}

				ok_Hash.put("tAdvancedHash_row9", true);
				end_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row9 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_6 finally ] start
				 */

				currentComponent = "tDBInput_6";

				/**
				 * [tDBInput_6 finally ] stop
				 */

				/**
				 * [tDBInput_7 finally ] start
				 */

				currentComponent = "tDBInput_7";

				/**
				 * [tDBInput_7 finally ] stop
				 */

				/**
				 * [tUnite_2 finally ] start
				 */

				currentComponent = "tUnite_2";

				/**
				 * [tUnite_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row9 finally ] start
				 */

				currentComponent = "tAdvancedHash_row9";

				/**
				 * [tAdvancedHash_row9 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_6_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
		final static byte[] commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		static byte[] commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String Hotel_Name;

		public String getHotel_Name() {
			return this.Hotel_Name;
		}

		public Integer Number_of_Stars;

		public Integer getNumber_of_Stars() {
			return this.Number_of_Stars;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.Hotel_Name == null) ? 0 : this.Hotel_Name.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row4Struct other = (row4Struct) obj;

			if (this.Hotel_Name == null) {
				if (other.Hotel_Name != null)
					return false;

			} else if (!this.Hotel_Name.equals(other.Hotel_Name))

				return false;

			return true;
		}

		public void copyDataTo(row4Struct other) {

			other.Hotel_Name = this.Hotel_Name;
			other.Number_of_Stars = this.Number_of_Stars;

		}

		public void copyKeysDataTo(row4Struct other) {

			other.Hotel_Name = this.Hotel_Name;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length) {
					if (length < 1024 && commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation.length == 0) {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[1024];
					} else {
						commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length);
				strReturn = new String(commonByteArray_DW_PI__Copy_of_Alimenter_fact_reservation, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.Hotel_Name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DW_PI__Copy_of_Alimenter_fact_reservation) {

				try {

					int length = 0;

					this.Hotel_Name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Hotel_Name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.Hotel_Name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.Number_of_Stars = readInteger(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.Number_of_Stars = readInteger(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeInteger(this.Number_of_Stars, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeInteger(this.Number_of_Stars, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Hotel_Name=" + Hotel_Name);
			sb.append(",Number_of_Stars=" + String.valueOf(Number_of_Stars));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Hotel_Name, other.Hotel_Name);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row4Struct row4 = new row4Struct();

				/**
				 * [tAdvancedHash_row4 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row4", false);
				start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tAdvancedHash_row4 = 0;

				// connection name:row4
				// source node:tFileInputDelimited_1 - inputs:(after_tDBInput_1)
				// outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4)
				// outputs:()
				// linked node: tMap_1 - inputs:(row3,row5,row6,row9,row4) outputs:(nbvc)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row4Struct>getLookup(matchingModeEnum_row4);

				globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);

				/**
				 * [tAdvancedHash_row4 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				int tos_count_tFileInputDelimited_1 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				int footer_tFileInputDelimited_1 = 0;
				int totalLinetFileInputDelimited_1 = 0;
				int limittFileInputDelimited_1 = -1;
				int lastLinetFileInputDelimited_1 = -1;

				char fieldSeparator_tFileInputDelimited_1[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_1 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_1[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_1 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_1 = /** Start field tFileInputDelimited_1:FILENAME */
						"C:/Users/User/Downloads/hotels_with_stars.csv"/** End field tFileInputDelimited_1:FILENAME */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_1 = null;

				try {

					String[] rowtFileInputDelimited_1 = null;
					int currentLinetFileInputDelimited_1 = 0;
					int outputLinetFileInputDelimited_1 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_1 = 0;
							if (footer_value_tFileInputDelimited_1 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_1,
									fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
						} else {
							csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_1),
									fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
						}

						csvReadertFileInputDelimited_1.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_1[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_1[0] != '\r'))
							csvReadertFileInputDelimited_1.setLineEnd("" + rowSeparator_tFileInputDelimited_1[0]);

						csvReadertFileInputDelimited_1.setQuoteChar('"');

						csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());

						if (footer_tFileInputDelimited_1 > 0) {
							for (totalLinetFileInputDelimited_1 = 0; totalLinetFileInputDelimited_1 < 1; totalLinetFileInputDelimited_1++) {
								csvReadertFileInputDelimited_1.readNext();
							}
							csvReadertFileInputDelimited_1.setSkipEmptyRecords(false);
							while (csvReadertFileInputDelimited_1.readNext()) {

								totalLinetFileInputDelimited_1++;

							}
							int lastLineTemptFileInputDelimited_1 = totalLinetFileInputDelimited_1
									- footer_tFileInputDelimited_1 < 0 ? 0
											: totalLinetFileInputDelimited_1 - footer_tFileInputDelimited_1;
							if (lastLinetFileInputDelimited_1 > 0) {
								lastLinetFileInputDelimited_1 = lastLinetFileInputDelimited_1 < lastLineTemptFileInputDelimited_1
										? lastLinetFileInputDelimited_1
										: lastLineTemptFileInputDelimited_1;
							} else {
								lastLinetFileInputDelimited_1 = lastLineTemptFileInputDelimited_1;
							}

							csvReadertFileInputDelimited_1.close();
							if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_1,
										fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
							} else {
								csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_1),
										fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
							}
							csvReadertFileInputDelimited_1.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_1[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_1[0] != '\r'))
								csvReadertFileInputDelimited_1.setLineEnd("" + rowSeparator_tFileInputDelimited_1[0]);

							csvReadertFileInputDelimited_1.setQuoteChar('"');

							csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());

						}

						if (limittFileInputDelimited_1 != 0) {
							for (currentLinetFileInputDelimited_1 = 0; currentLinetFileInputDelimited_1 < 1; currentLinetFileInputDelimited_1++) {
								csvReadertFileInputDelimited_1.readNext();
							}
						}
						csvReadertFileInputDelimited_1.setSkipEmptyRecords(false);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_1 != 0 && csvReadertFileInputDelimited_1 != null
							&& csvReadertFileInputDelimited_1.readNext()) {
						rowstate_tFileInputDelimited_1.reset();

						rowtFileInputDelimited_1 = csvReadertFileInputDelimited_1.getValues();

						currentLinetFileInputDelimited_1++;

						if (lastLinetFileInputDelimited_1 > -1
								&& currentLinetFileInputDelimited_1 > lastLinetFileInputDelimited_1) {
							break;
						}
						outputLinetFileInputDelimited_1++;
						if (limittFileInputDelimited_1 > 0
								&& outputLinetFileInputDelimited_1 > limittFileInputDelimited_1) {
							break;
						}

						row4 = null;

						row4 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row4 = new row4Struct();
						try {

							char fieldSeparator_tFileInputDelimited_1_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_1_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row4.Hotel_Name = null;

								row4.Number_of_Stars = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_1 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_1 = 0;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row4.Hotel_Name = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row4.Hotel_Name = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 1;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									if (rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1].length() > 0) {
										try {

											row4.Number_of_Stars = ParserUtils.parseTo_Integer(
													rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1]);

										} catch (java.lang.Exception ex_tFileInputDelimited_1) {
											globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",
													ex_tFileInputDelimited_1.getMessage());
											rowstate_tFileInputDelimited_1.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"Number_of_Stars", "row4",
															rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1],
															ex_tFileInputDelimited_1),
													ex_tFileInputDelimited_1));
										}
									} else {

										row4.Number_of_Stars = null;

									}

								} else {

									row4.Number_of_Stars = null;

								}

							}

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_1 = true;

							System.err.println(e.getMessage());
							row4 = null;

							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */

						/**
						 * [tFileInputDelimited_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_begin ] stop
						 */
// Start of branch "row4"
						if (row4 != null) {

							/**
							 * [tAdvancedHash_row4 main ] start
							 */

							currentComponent = "tAdvancedHash_row4";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row4"

								);
							}

							row4Struct row4_HashRow = new row4Struct();

							row4_HashRow.Hotel_Name = row4.Hotel_Name;

							row4_HashRow.Number_of_Stars = row4.Number_of_Stars;

							tHash_Lookup_row4.put(row4_HashRow);

							tos_count_tAdvancedHash_row4++;

							/**
							 * [tAdvancedHash_row4 main ] stop
							 */

							/**
							 * [tAdvancedHash_row4 process_data_begin ] start
							 */

							currentComponent = "tAdvancedHash_row4";

							/**
							 * [tAdvancedHash_row4 process_data_begin ] stop
							 */

							/**
							 * [tAdvancedHash_row4 process_data_end ] start
							 */

							currentComponent = "tAdvancedHash_row4";

							/**
							 * [tAdvancedHash_row4 process_data_end ] stop
							 */

						} // End of branch "row4"

						/**
						 * [tFileInputDelimited_1 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						nb_line_tFileInputDelimited_1++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_1 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_1 != null) {
							csvReadertFileInputDelimited_1.close();
						}
					}
					if (csvReadertFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE", nb_line_tFileInputDelimited_1);
					}

				}

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
				 */

				/**
				 * [tAdvancedHash_row4 end ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				tHash_Lookup_row4.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tAdvancedHash_row4", true);
				end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row4 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				/**
				 * [tFileInputDelimited_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row4 finally ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				/**
				 * [tAdvancedHash_row4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final Copy_of_Alimenter_fact_reservation Copy_of_Alimenter_fact_reservationClass = new Copy_of_Alimenter_fact_reservation();

		int exitCode = Copy_of_Alimenter_fact_reservationClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = Copy_of_Alimenter_fact_reservation.class.getClassLoader()
					.getResourceAsStream(
							"dw_pi_/copy_of_alimenter_fact_reservation_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Copy_of_Alimenter_fact_reservation.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_1) {
			globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

			e_tDBInput_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : Copy_of_Alimenter_fact_reservation");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 223843 characters generated by Talend Open Studio for Data Integration on the
 * 11 mars 2025 à 18:56:53 WAT
 ************************************************************************************************/