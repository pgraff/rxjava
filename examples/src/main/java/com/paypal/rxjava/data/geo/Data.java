package com.paypal.rxjava.data.geo;

public class Data {
	public final static class Country {
		private String name;
		private String countryCode;
		public Country(String name, String countryCode) {
			this.name = name;
			this.countryCode = countryCode;
		}
		public String getName() {
			return name;
		}
		public String getCountryCode() {
			return countryCode;
		}
	}
	public final static class Continent {
		String name;
		Country countries[];
		public Continent(String name, Country[] countries) {
			this.name = name;
			this.countries = countries;
		}
		public String getName() {
			return name;
		}
		public Country[] getCountries() {
			return countries;
		}
	}
	
	public final static Continent [] continents = {
			new Continent("Africa", new Country[] {
					new Country("Angola", "AGO"),
					new Country("Benin", "BEN"),
				    new Country("Botswana", "BWA"),
				    new Country("Burkina Faso", "BFA"),
				    new Country("Burundi", "BDI"),
				    new Country("Cameroon", "CMR"),
				    new Country("Chad", "TCD"),
				    new Country("Comoros", "COM"),
				    new Country("Congo", "COG"),
				    new Country("Djibouti", "DJI"),
				    new Country("Egypt", "EGY"),
				    new Country("Ethiopia", "ETH"),
				    new Country("Gabon", "GAB"),
				    new Country("Gambia", "GMB"),
				    new Country("Ghana", "GHA"),
				    new Country("Guinea", "GIN"),
				    new Country("Ivory Coast", "CIV"),
				    new Country("Kenya", "KEN"),
				    new Country("Lesotho", "LSO"),
				    new Country("Liberia", "LBR"),
				    new Country("Madagascar", "MDG"),
				    new Country("Malawi", "MWI"),
				    new Country("Mali", "MLI"),
				    new Country("Mauritania", "MRT"),
				    new Country("Mauritius", "MUS"),
				    new Country("Morocco", "MAR"),
				    new Country("Mozambique", "MOZ"),
				    new Country("Namibia", "NAM"),
				    new Country("Niger", "NER"),
				    new Country("Nigeria", "NGA"),
				    new Country("Reunion", "REU"),
				    new Country("Rwanda", "RWA"),
				    new Country("Senegal", "SEN"),
				    new Country("Seychelles", "SYC"),
				    new Country("Sierra Leone", "SLE"),
				    new Country("Somalia", "SOM"),
				    new Country("South Africa", "ZAF"),
				    new Country("Sudan", "SDN"),
				    new Country("Swaziland", "SWZ"),
				    new Country("Tanzania", "TZA"),
				    new Country("Togo", "TGO"),
				    new Country("Tunisia", "TUN"),
				    new Country("Uganda", "UGA"),
				    new Country("Zaire", "ZAR"),
				    new Country("Zambia", "ZMB"),
				    new Country("Zimbabwe", "ZWE")
				    }),
			new Continent("North and Central America", new Country[] {
					new Country("Bahamas", "BHS"),
					new Country("Barbados", "BRB"),
					new Country("Belize", "BLZ"),
					new Country("Canada", "CAN"),
					new Country("Costa Rica", "CRI"),
					new Country("Dominica", "DMA"),
					new Country("Dominican Rep.", "DOM"),
					new Country("El Salvador", "SLV"),
					new Country("Grenada", "GRD"),
					new Country("Guatemala", "GTM"),
					new Country("Haiti", "HTI"),
					new Country("Honduras", "HND"),
					new Country("Jamaica", "JAM"),
					new Country("Mexico", "MEX"),
					new Country("Nicaragua", "NIC"),
					new Country("Panama", "PAN"),
					new Country("Puerto Rico", "PRI"),
					new Country("Saint Kitts & Nevis", "KNA"),
					new Country("Saint Lucia", "LCA"),
					new Country("Saint Vincent & Grenadines", "VCT"),
					new Country("Trinidad & Tobago", "TTO"),
					new Country("United States of America ", "USA")
			}),
			new Continent("South America", new Country[] {
					new Country("Argentina", "ARG"),
					new Country("Bolivia", "BOL"),
					new Country("Brazil", "BRA"),
					new Country("Chile", "CHL"),
					new Country("Colombia", "COL"),
					new Country("Ecuador", "ECU"),
					new Country("Guyana", "GUY"),
					new Country("Paraguay", "PRY"),
					new Country("Peru", "PER"),
					new Country("Suriname", "SUR"),
					new Country("Uruguay", "URY"),
					new Country("Venezuela ", "VEN")
				}),
			new Continent("Asia", new Country[] {
					new Country("Bahrain", "BHR"),
					new Country("Bangladesh", "BGD"),
					new Country("Bhutan", "BTN"),
					new Country("China", "CHN"),
					new Country("Hong Kong", "HKG"),
					new Country("India", "IND"),
					new Country("Indonesia", "IDN"),
					new Country("Iran", "IRN"),
					new Country("Iraq", "IRQ"),
					new Country("Israel", "ISR"),
					new Country("Japan", "JPN"),
					new Country("Jordan", "JOR"),
					new Country("Korea, Rep. (South)", "KOR"),
					new Country("Kuwait", "KWT"),
					new Country("Laos", "LAO"),
					new Country("Malaysia", "MYS"),
					new Country("Mongolia", "MNG"),
					new Country("Myanmar", "MMR"),
					new Country("Nepal", "NPL"),
					new Country("Oman", "OMN"),
					new Country("Pakistan", "PAK"),
					new Country("Philippines", "PHL"),
					new Country("Qatar", "QAT"),
					new Country("Saudi Arabia", "SAU"),
					new Country("Singapore", "SGP"),
					new Country("Sri Lanka", "LKA"),
					new Country("Syria", "SYR"),
					new Country("Taiwan", "TWN"),
					new Country("Thailand", "THA"),
					new Country("United Arab E.", "ARE"),
					new Country("Yemen ", "YEM")
				}),
			new Continent("Europe", new Country[] {
					new Country("Austria", "AUT"),
					new Country("Belgium", "BEL"),
					new Country("Bulgaria", "BGR"),
					new Country("Cyprus", "CYP"),
					new Country("Czechoslovakia", "CSK"),
					new Country("Denmark", "DNK"),
					new Country("Finland", "FIN"),
					new Country("France", "FRA"),
					new Country("Germany", "GER"),
					new Country("Greece", "GRC"),
					new Country("Hungary", "HUN"),
					new Country("Iceland", "ISL"),
					new Country("Ireland", "IRL"),
					new Country("Italy", "ITA"),
					new Country("Luxembourg", "LUX"),
					new Country("Malta", "MLT"),
					new Country("Netherlands", "NLD"),
					new Country("Norway", "NOR"),
					new Country("Poland", "POL"),
					new Country("Portugal", "PRT"),
					new Country("Romania", "ROM"),
					new Country("Russia", "RUS"),
					new Country("Spain", "ESP"),
					new Country("Sweden", "SWE"),
					new Country("Switzerland", "CHE"),
					new Country("Turkey", "TUR"),
					new Country("Yugoslavia", "YUG"),
					new Country("United Kingdom ", "GBR")
				}),
			new Continent("Australia", new Country[] {
					new Country("Australia", "AUS"),
					new Country("Fiji", "FJI"),
					new Country("New Zealand", "NZL"),
					new Country("Tonga", "TON"),
					new Country("Vanuatu", "VUT"),
					new Country("Western Samoa ", "WSM")
				})
	};

}
