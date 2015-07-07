package jp.gr.java_conf.androtaku.countrylist;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility for controlling country names on country_code.csv
 */
public class CountryList {

    static public DataLanguage dataLanguage = DataLanguage.ENGLISH;

    /**
     * get all country names
     * @return List<String> names of countries
     */
    static public List<String> getCountryNames(Context context){
        InputStream inputStream = context.getResources().openRawResource(getFileId());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> names = new ArrayList<>();
        String tempString;
        try {
            while ((tempString = reader.readLine()) != null){
                int index = tempString.indexOf(",");
                String name = tempString.substring(0,index);
                names.add(name);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return names;
    }

    /**
     * get all country codes
     * @return List<String> codes of countries
     */
    static public List<String> getCountryCodes(Context context){
        InputStream inputStream = context.getResources().openRawResource(getFileId());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> codes = new ArrayList<>();
        String tempString;
        try {
            while ((tempString = reader.readLine()) != null){
                int index = tempString.indexOf(",");
                String code = tempString.substring(index + 1,tempString.length());
                codes.add(code);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return codes;
    }

    /**
     * get all countries
     * @return List<Country> country object list
     */
    static public List<Country> getCountries(Context context){
        InputStream inputStream = context.getResources().openRawResource(getFileId());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<Country> countries = new ArrayList<>();
        String tempString;
        try {
            while ((tempString = reader.readLine()) != null){
                Country country = new Country();
                int index = tempString.indexOf(",");
                String name = tempString.substring(0,index);
                String code = tempString.substring(index + 1);
                country.setName(name);
                country.setCode(code);
                countries.add(country);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return countries;
    }

    /**
     * convert country name to 2 alphabets code
     * @param name country name
     * @return String country code
     */
    @Nullable
    static public String convertNameToCode(Context context, String name){
        InputStream inputStream = context.getResources().openRawResource(getFileId());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String tempString;
        try {
            while ((tempString = reader.readLine()) != null){
                int index = tempString.lastIndexOf(name);
                if(index != -1) {
                    return tempString.substring(name.length() + 1, tempString.length());
                }
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * convert country 2 alphabets code to country name
     * @param code 2 alphabets country code
     * @return String country name
     */
    @Nullable
    static public String convertCodeToName(Context context, String code){
        InputStream inputStream = context.getResources().openRawResource(getFileId());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String tempString;
        try {
            while ((tempString = reader.readLine()) != null){
                int index = tempString.lastIndexOf(code);
                if(index != -1) {
                    return tempString.substring(0, index - 1);
                }
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * get Country object by name
     * @param name country name
     * @return Country
     */
    @Nullable
    static public Country getCountryByName(Context context, String name){
        InputStream inputStream = context.getResources().openRawResource(getFileId());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String tempString;
        try {
            while ((tempString = reader.readLine()) != null){
                int index = tempString.lastIndexOf(name);
                if(index != -1) {
                    String code =  tempString.substring(name.length() + 1, tempString.length());
                    Country country = new Country();
                    country.setName(name);
                    country.setCode(code);
                    return country;
                }
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * get Country object by code
     * @param code country code
     * @return Country
     */
    @Nullable
    static public Country getCountryByCode(Context context, String code){
        InputStream inputStream = context.getResources().openRawResource(getFileId());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String tempString;
        try {
            while ((tempString = reader.readLine()) != null){
                int index = tempString.lastIndexOf(code);
                if(index != -1) {
                    String name = tempString.substring(0, index - 1);
                    Country country = new Country();
                    country.setName(name);
                    country.setCode(code);
                    return country;
                }
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    static private int getFileId(){
        int id;
        switch(dataLanguage){
            case ENGLISH:
                id = R.raw.country_code;
                break;
            case JAPANESE:
                id = R.raw.country_code_jp;
                break;
            default:
                id = R.raw.country_code;
                break;
        }
        return id;
    }
}
