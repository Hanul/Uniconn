package UPPERCASE.JAVA.JSON;

import java.util.Date;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UTIL {

	/**
	 * extend array.
	 * 
	 * @param originArray
	 * @param extendArray
	 */
	public static void EXTEND_ARRAY(JSONArray originArray, JSONArray extendArray) {

		try {

			for (int i = 0; i < extendArray.length(); i += 1) {
				Object value = extendArray.get(i);

				// when value is Date type
				if (value instanceof Date) {
					originArray.put(i, new Date(((Date) value).getTime()));
				}

				// when value is data
				else if (value instanceof JSONObject) {
					originArray.put(i, COPY_DATA((JSONObject) value));
				}

				// when value is array
				else if (value instanceof JSONArray) {
					originArray.put(i, COPY_ARRAY((JSONArray) value));
				}

				else {
					originArray.put(i, value);
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * extend data.
	 * 
	 * @param originData
	 * @param extendData
	 */
	public static void EXTEND_DATA(JSONObject originData, JSONObject extendData) {

		try {

			@SuppressWarnings("unchecked")
			Iterator<String> iterator = extendData.keys();

			while (iterator.hasNext()) {

				String name = iterator.next();
				Object value = extendData.get(name);

				// when value is Date type
				if (value instanceof Date) {
					originData.put(name, new Date(((Date) value).getTime()));
				}

				// when value is data
				else if (value instanceof JSONObject) {
					originData.put(name, COPY_DATA((JSONObject) value));
				}

				// when value is array
				else if (value instanceof JSONArray) {
					originData.put(name, COPY_ARRAY((JSONArray) value));
				}

				else {
					originData.put(name, value);
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * copy array.
	 * 
	 * @param jsonArray
	 * @return copiedArray
	 */
	public static JSONArray COPY_ARRAY(JSONArray jsonArray) {

		JSONArray copy = new JSONArray();

		EXTEND_ARRAY(copy, jsonArray);

		return copy;
	}

	/**
	 * copy data.
	 * 
	 * @param json
	 * @return copiedData
	 */
	public static JSONObject COPY_DATA(JSONObject json) {

		JSONObject copy = new JSONObject();

		EXTEND_DATA(copy, json);

		return copy;
	}

	/**
	 * pack data with Date type.
	 * 
	 * @param json
	 * @return packedData
	 */
	public static JSONObject PACK_DATA(JSONObject json) {

		JSONObject result = null;

		try {

			// result
			result = COPY_DATA(json);

			// date attribute names
			JSONArray dateAttrNames = new JSONArray();

			@SuppressWarnings("unchecked")
			Iterator<String> iterator = result.keys();

			while (iterator.hasNext()) {

				String name = iterator.next();
				Object value = result.get(name);

				// when value is Date type
				if (value instanceof Date) {

					// change to timestamp integer.
					result.put(name, ((Date) value).getTime());
					dateAttrNames.put(name);
				}

				// when value is data
				else if (value instanceof JSONObject) {
					result.put(name, PACK_DATA((JSONObject) value));
				}

				// when value is array
				else if (value instanceof JSONArray) {

					for (int i = 0; i < ((JSONArray) value).length(); i += 1) {
						Object v = ((JSONArray) value).get(i);

						if (v instanceof JSONObject) {
							((JSONArray) value).put(i, PACK_DATA((JSONObject) v));
						}
					}
				}
			}

			result.put("__DATE_ATTR_NAMES", dateAttrNames);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * unpack data with Date type.
	 * 
	 * @param json
	 * @return unpackedData
	 */
	public static JSONObject UNPACK_DATA(JSONObject json) {

		JSONObject result = null;

		try {

			// result
			result = COPY_DATA(json);

			// when date attribute names exists
			if (!result.isNull("__DATE_ATTR_NAMES")) {

				// change timestamp integer to Date type.
				for (int i = 0; i < ((JSONArray) result.get("__DATE_ATTR_NAMES")).length(); i += 1) {
					String dateAttrName = (String) ((JSONArray) result.get("__DATE_ATTR_NAMES")).get(i);
					result.put(dateAttrName, new Date((Long) result.get(dateAttrName)));
				}
				result.remove("__DATE_ATTR_NAMES");
			}

			@SuppressWarnings("unchecked")
			Iterator<String> iterator = result.keys();

			while (iterator.hasNext()) {

				String name = iterator.next();
				Object value = result.get(name);

				// when value is data
				if (value instanceof JSONObject) {
					result.put(name, UNPACK_DATA((JSONObject) value));
				}

				// when value is array
				else if (value instanceof JSONArray) {

					for (int i = 0; i < ((JSONArray) value).length(); i += 1) {
						Object v = ((JSONArray) value).get(i);

						if (v instanceof JSONObject) {
							((JSONArray) value).put(i, UNPACK_DATA((JSONObject) v));
						}
					}
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}
}

