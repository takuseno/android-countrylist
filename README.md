# android-countrylist
This library is Android library for using country names and 2-alphabet codes

##Usage
Add repository to your build.gradle
```gradle
repositories {
    maven { url {'https://raw.github.com/takuseno/android-countrylist/master/repository'}}
}

dependencies {
    compile 'jp.gr.java_conf.androtaku.countrylist:countrylist:1.0.0'
}
```

In your Java code
```java
//get all countries as objects that contain name and 2-alphabet code
List<Country> countries = CountryList.getCountries(context);

//get all country names as string list
List<String> countryNames = CountryList.getCountryNames(context);

//get all country 2-alphabet code as string list
List<String> countryCodes = CountryList.getCountryCodes(context);

//convert country name into 2-alphabet code
String code = CountryList.convertNameToCode(context, "Japan");
// in this case, code is "JP"

//convert country 2-alphabet code into name
String name = Country.convertCodeToName(context, "JP");
//in this case, name is "Japan"

//get Country object by country name
Country country = CountryList.getCountryByName(context, "Japan");

//get Country object by country 2-alphabet code
Country country = CountryList.getCountryByCode(context, "JP");
```

##Country List
If you add other countries, please modify [country_code.csv](https://github.com/takuseno/android-countrylist/blob/master/countrylist/src/main/res/raw/country_code.csv).
