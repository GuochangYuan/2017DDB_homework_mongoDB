package common.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 字符串工具类。
 * 
 * @author carver.gu
 * @since 1.0, Sep 12, 2009
 */
public abstract class StringUtils {

	private StringUtils() {}

	/**
	 * 检查指定的字符串是否为空。
	 * <ul>
	 * <li>SysUtils.isEmpty(null) = true</li>
	 * <li>SysUtils.isEmpty("") = true</li>
	 * <li>SysUtils.isEmpty("   ") = true</li>
	 * <li>SysUtils.isEmpty("abc") = false</li>
	 * </ul>
	 * 
	 * @param value 待检查的字符串
	 * @return true/false
	 */
	public static boolean isEmpty(String value) {
		int strLen;
		if (value == null || (strLen = value.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(value.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查对象是否为数字型字符串。
	 */
	public static boolean isNumeric(Object obj) {
		if (obj == null) {
			return false;
		}
		String str = obj.toString();
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查指定的字符串列表是否不为空。
	 */
	public static boolean areNotEmpty(String... values) {
		boolean result = true;
		if (values == null || values.length == 0) {
			result = false;
		} else {
			for (String value : values) {
				result &= !isEmpty(value);
			}
		}
		return result;
	}

	/**
	 * 把通用字符编码的字符串转化为汉字编码。
	 */
	public static String unicodeToChinese(String unicode) {
		StringBuilder out = new StringBuilder();
		if (!isEmpty(unicode)) {
			for (int i = 0; i < unicode.length(); i++) {
				out.append(unicode.charAt(i));
			}
		}
		return out.toString();
	}
	
	/**
	 * 过滤不可见字符
	 */
	public static String stripNonValidXMLCharacters(String input) {
		if (input == null || ("".equals(input)))
			return "";
		StringBuilder out = new StringBuilder();
		char current;
		for (int i = 0; i < input.length(); i++) {
			current = input.charAt(i);
			if ((current == 0x9) || (current == 0xA) || (current == 0xD)
					|| ((current >= 0x20) && (current <= 0xD7FF))
					|| ((current >= 0xE000) && (current <= 0xFFFD))
					|| ((current >= 0x10000) && (current <= 0x10FFFF)))
				out.append(current);
		}
		return out.toString();
	}
	
	private static final String CHANGE_PATH = "/"; // folder sep.

	private static final String WIN_CHANGE_PATH = "\\"; // Windows folder sep.

	private static final String TOP_PATH = ".."; // Top folder

	private static final String CURRENT_PATH = "."; // Current folder

	/**
	 * Check if a String has length.
	 * <p><pre>
	 * StringUtils.hasLength(null) = false
	 * StringUtils.hasLength("") = false
	 * StringUtils.hasLength(" ") = true
	 * StringUtils.hasLength("Hello") = true
	 * </pre>
	 * @param str the String to check, may be null
	 * @return <code>true</code> if the String is not null and has length
	 */
	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * Check if a String has text. More specifically, returns <code>true</code>
	 * if the string not <code>null<code>, it's <code>length is > 0</code>, and
	 * it has at least one non-whitespace character.
	 * <p><pre>
	 * StringUtils.hasText(null) = false
	 * StringUtils.hasText("") = false
	 * StringUtils.hasText(" ") = false
	 * StringUtils.hasText("12345") = true
	 * StringUtils.hasText(" 12345 ") = true
	 * </pre>
	 * @param str the String to check, may be null
	 * @return <code>true</code> if the String is not null, length > 0,
	 * and not whitespace only
	 */
	public static boolean hasText(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return false;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Count the occurrences of the substring in string s.
	 * @param s string to search in. Return 0 if this is null.
	 * @param sub string to search for. Return 0 if this is null.
	 */
	public static int countOccurrencesOf(String s, String sub) {
		if (s == null || sub == null || "".equals(sub)) {
			return 0;
		}
		int count = 0, pos = 0, idx = 0;
		while ((idx = s.indexOf(sub, pos)) != -1) {
			++count;
			pos = idx + sub.length();
		}
		return count;
	}

	/**
	 * Replace all occurences of a substring within a string with
	 * another string.
	 * @param inString String to examine
	 * @param oldPattern String to replace
	 * @param newPattern String to insert
	 * @return a String with the replacements
	 */
	public static String replace(String inString, String oldPattern, String newPattern) {
		if (inString == null) {
			return null;
		}
		
		if (oldPattern == null || newPattern == null) {
			return inString;
		}

		StringBuffer sbuf = new StringBuffer();
		
		// output StringBuffer we'll build up
		int pos = 0; // Our position in the old string
		int index = inString.indexOf(oldPattern);
		// the index of an occurrence we've found, or -1
		int patLen = oldPattern.length();
		while (index >= 0) {
			sbuf.append(inString.substring(pos, index));
			sbuf.append(newPattern);
			pos = index + patLen;
			index = inString.indexOf(oldPattern, pos);
		}
		
		sbuf.append(inString.substring(pos));

		// remember to append any characters to the right of a match
		return sbuf.toString();
	}

	/**
	 * Delete all occurrences of the given substring.
	 * @param pattern the pattern to delete all occurrences of
	 */
	public static String delete(String inString, String pattern) {
		return replace(inString, pattern, "");
	}

	/**
	 * Delete any character in a given string.
	 * @param chars characters to delete.
	 * E.g. az\n will delete as, zs and new lines.
	 */
	public static String deleteAny(String inString, String chars) {
		if (inString == null || chars == null) {
			return inString;
		}
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < inString.length(); i++) {
			char c = inString.charAt(i);
			if (chars.indexOf(c) == -1) {
				out.append(c);
			}
		}
		return out.toString();
	}

	/**
	 * Tokenize the given String into a String array via a StringTokenizer.
	 * @param s the String to tokenize
	 * @param delimiters the delimiter characters, assembled as String
	 * @param trimTokens trim the tokens via String.trim
	 * @param ignoreEmptyTokens omit empty tokens from the result array
	 * @return an array of the tokens
	 * @see java.util.StringTokenizer
	 * @see java.lang.String#trim
	 */
	public static String[] tokenizeToStringArray(String s, String delimiters,
			boolean trimTokens, boolean ignoreEmptyTokens) {
		StringTokenizer st = new StringTokenizer(s, delimiters);
		List tokens = new ArrayList();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (trimTokens) {
				token = token.trim();
			}
			if (!(ignoreEmptyTokens && token.length() == 0)) {
				tokens.add(token);
			}
		}
		return (String[]) tokens.toArray(new String[tokens.size()]);
	}
	
	/**
	 * Take a String which is a delimited list and convert it to a List.
	 * @param s String
	 * @param delim delim (this will not be returned)
	 * @return an list of the tokens in the list
	 */
	public static List delimitedListToStringList(String s, String delim) {
		List l = new LinkedList();
		if (s == null) {
			return l;
		}
		if (delim == null) {
			l.add(s);
			return l;
		}

		int pos = 0;
		int delPos = 0;
		while ((delPos = s.indexOf(delim, pos)) != -1) {
			l.add(s.substring(pos, delPos));
			pos = delPos + delim.length();
		}
		if (pos <= s.length()) {
			// add rest of String
			l.add(s.substring(pos));
		}

		return l;
	}	

	/**
	 * Take a String which is a delimited list and convert it to a String array.
	 * @param s String
	 * @param delim delim (this will not be returned)
	 * @return an array of the tokens in the list
	 */
	public static String[] delimitedListToStringArray(String s, String delim) {
		if (s == null) {
			return new String[0];
		}
		if (delim == null) {
			return new String[] { s };
		}

		List l = new LinkedList();
		int pos = 0;
		int delPos = 0;
		while ((delPos = s.indexOf(delim, pos)) != -1) {
			l.add(s.substring(pos, delPos));
			pos = delPos + delim.length();
		}
		if (pos <= s.length()) {
			// add rest of String
			l.add(s.substring(pos));
		}

		return (String[]) l.toArray(new String[l.size()]);
	}

	/**
	 * Convert a CSV list into an array of Strings.
	 * @param s CSV list
	 * @return an array of Strings, or the empty array if s is null
	 */
	public static String[] commaDelimitedListToStringArray(String s) {
		return delimitedListToStringArray(s, ",");
	}

	/**
	 * Convenience method to convert a CSV string list to a set.
	 * Note that this will suppress duplicates.
	 * @param s CSV String
	 * @return a Set of String entries in the list
	 */
	public static Set commaDelimitedListToSet(String s) {
		Set set = new TreeSet();
		String[] tokens = commaDelimitedListToStringArray(s);
		for (int i = 0; i < tokens.length; i++) {
			set.add(tokens[i]);
		}
		return set;
	}

	/**
	 * Convenience method to return a String array as a delimited (e.g. CSV)
	 * String. E.g. useful for toString() implementations.
	 * @param arr array to display. Elements may be of any type (toString
	 * will be called on each element).
	 * @param delim delimiter to use (probably a ,)
	 */
	public static String arrayToDelimitedString(Object[] arr, String delim) {
		if (arr == null) {
			return "null";
		} else {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				if (i > 0)
					sb.append(delim);
				sb.append(arr[i]);
			}
			return sb.toString();
		}
	}

	/**
	 * Convenience method to return a Collection as a delimited (e.g. CSV)
	 * String. E.g. useful for toString() implementations.
	 * @param c Collection to display
	 * @param delim delimiter to use (probably a ",")
	 */
	public static String collectionToDelimitedString(Collection c, String delim) {
		if (c == null) {
			return "null";
		}
		StringBuffer sb = new StringBuffer();
		Iterator it = c.iterator();
		int i = 0;
		while (it.hasNext()) {
			if (i++ > 0) {
				sb.append(delim);
			}
			sb.append(it.next());
		}
		return sb.toString();
	}

	/**
	 * Convenience method to return a String array as a CSV String.
	 * E.g. useful for toString() implementations.
	 * @param arr array to display. Elements may be of any type (toString
	 * will be called on each element).
	 */
	public static String arrayToCommaDelimitedString(Object[] arr) {
		return arrayToDelimitedString(arr, ",");
	}

	/**
	 * Convenience method to return a Collection as a CSV String.
	 * E.g. useful for toString() implementations.
	 * @param c Collection to display
	 */
	public static String collectionToCommaDelimitedString(Collection c) {
		return collectionToDelimitedString(c, ",");
	}

	/**
	 * Append the given String to the given String array, returning a new array
	 * consisting of the input array contents plus the given String.
	 * @param arr the array to append to
	 * @param s the String to append
	 * @return the new array
	 */
	public static String[] addStringToArray(String[] arr, String s) {
		String[] newArr = new String[arr.length + 1];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		newArr[arr.length] = s;
		return newArr;
	}

	/**
	 * Unqualify a string qualified by a '.' dot character. For example,
	 * "this.name.is.qualified", returns "qualified".
	 * @param qualifiedName the qualified name
	 */
	public static String unqualify(String qualifiedName) {
		return unqualify(qualifiedName, '.');
	}

	/**
	 * Unqualify a string qualified by a separator character. For example,
	 * "this:name:is:qualified" returns "qualified" if using a ':' separator.
	 * @param qualifiedName the qualified name
	 * @param separator the separator
	 */
	public static String unqualify(String qualifiedName, char separator) {
		return qualifiedName
				.substring(qualifiedName.lastIndexOf(separator) + 1);
	}

	/**
	 * Capitalize a <code>String</code>, changing the first letter to
	 * upper case as per {@link Character#toLowerCase(char)}.
	 * No other letters are changed.
	 * @param str the String to capitalize, may be null
	 * @return the capitalized String, <code>null</code> if null
	 */
	public static String capitalize(String str) {
		return changeFirstCharacterCase(true, str);
	}

	/**
	 * Uncapitalize a <code>String</code>, changing the first letter to
	 * lower case as per {@link Character#toLowerCase(char)}.
	 * No other letters are changed.
	 * @param str the String to uncapitalize, may be null
	 * @return the uncapitalized String, <code>null</code> if null
	 */
	public static String uncapitalize(String str) {
		return changeFirstCharacterCase(false, str);
	}

	private static String changeFirstCharacterCase(boolean capitalize,
			String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return str;
		}
		StringBuffer buf = new StringBuffer(strLen);
		if (capitalize) {
			buf.append(Character.toUpperCase(str.charAt(0)));
		} else {
			buf.append(Character.toLowerCase(str.charAt(0)));
		}
		buf.append(str.substring(1));
		return buf.toString();
	}

	/**
	 * Normalize the path by suppressing sequences like "path/.." and
	 * inner simple dots folders.
	 * <p>The result is convenient for path comparison. For other uses,
	 * notice that Windows separators ("\") are replaced by simple dashes.
	 * @param path The original path
	 * @return The normalized path
	 */
	public static String cleanPath(String path) {
		String p = replace(path, WIN_CHANGE_PATH, CHANGE_PATH);
		String[] pArray = delimitedListToStringArray(p, CHANGE_PATH);
		List pList = new LinkedList();
		int tops = 0;
		for (int i = pArray.length - 1; i >= 0; i--) {
			if (CURRENT_PATH.equals(pArray[i])) {
				// Do nothing
			} else if (TOP_PATH.equals(pArray[i])) {
				tops++;
			} else {
				if (tops > 0) {
					tops--;
				} else {
					pList.add(0, pArray[i]);
				}
			}
		}
		return collectionToDelimitedString(pList, CHANGE_PATH);
	}

	/**
	 * Compare two paths after normalization of them.
	 * @param path1 First path for comparizon
	 * @param path2 Second path for comparizon
	 * @return True if the two paths are equivalent after normalization
	 */
	public static boolean pathEquals(String path1, String path2) {
		return cleanPath(path1).equals(cleanPath(path2));
	}
	
	public static boolean isEmailAddress(String email) {
		if (hasText(email)) {
    		int at = email.indexOf( '@' );
    		int dot = email.lastIndexOf( '.' );
    		if ( at == -1 || at == 0 || dot == -1 || at > dot-1 ) {
    			return false;
    		}
    		return true;
    	}
		return false;
	}
	
	/**
	 * ȷ����Ϊnull, ����ȥͷβ�ǿո�
	 * @param value
	 * @return
	 */
	public static String toText(String value) {
		if (value == null) return "";
		else return value.trim();
	}
	
	public static String ensureNoEmpty(String value) {
		if (value == null || "".equals(value)) return " ";
		else return value;
	}
	
	/**
	 * 将字符串转换成UTF-8编码的字符串
	 * */
	public static String toUtf8(String input) {
		String result=input;
		if (input != null) {
			try {
				result=new String(input.getBytes("iso-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
               //忽略此异常              
			}
		}
		return result;
	}   
	public static String escapeSQLLike(String likeStr) {
        String str = StringUtils.replace(likeStr, "_", "/_");
        str = replace(str, "%", "/%");
        str = replace(str, "?", "_");
        str = replace(str, "*", "%");
        return str;
    }
	
	/**
	 * 去除URL"//" "\"
	 * @param url
	 * @return
	 */
	public static String escapeURL(String url){
		url = toText(url).replace("\\", "/").replace("//", "/")
		.replace("http:/", "http://");
		return url;
	}
	
	public static String escapeLinuxPath(String filePath){
		filePath = toText(filePath).replace("\\", "/").replace("//", "/")
			.replace("/\\", "/").replace("\\\\", "/").replace("////", "/");
		return filePath;
	}
	
	public static String escapeFileNameToSysTime(String fileName){
		if(fileName == null) return null;
		if(!fileName.contains(".")) return "";
		String fileext = fileName.substring(fileName.lastIndexOf("."),fileName.length());
		fileName = System.currentTimeMillis()+fileext;
		return fileName;
	}

	public static String escapeThumFileName(String filename) {
		return "thum_"+filename;
	}
	
	public static InputStream String2InputStream(String str){
	    ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
	    return stream;
	}


}
