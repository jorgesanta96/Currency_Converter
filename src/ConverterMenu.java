
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class ConverterMenu {
	public static void main(String[] args) {
		
		boolean continueConverter = true;
		
		while (continueConverter) {
			List<String> optionConvertorList = new ArrayList<String>();
			optionConvertorList.add("Conversor Monedas");
			optionConvertorList.add("Conversor Temperatura");
			Object[] optionsConvertor = optionConvertorList.toArray();
			Object optionConvertorSelected = JOptionPane.showInputDialog(null, 
			                                           "Seleccione una opcion de Conversor", 
			                                           "Conversor", 
			                                            JOptionPane.PLAIN_MESSAGE, 
			                                            null,
			                                            optionsConvertor, 
			                                            optionsConvertor[0]);
			
			System.out.println(optionConvertorList);
			System.out.println(optionConvertorSelected);
			
//			Si se da cancelar o cerrar en la app, entonces cerramos el ciclo y por ende la app
			if (optionConvertorSelected == null) {
				break;
			}
			
			boolean validValue = false;
			Object valueToConvert;
			
			do {
				valueToConvert = JOptionPane.showInputDialog(null, 
						"Ingrese el Valor a convertir", 
						"Input", 
						JOptionPane.QUESTION_MESSAGE);

				System.out.println(valueToConvert);
								
				if (valueToConvert != null && onlyDigits(valueToConvert.toString())) {
					validValue = true;
				} else {
					JOptionPane.showMessageDialog(null,
							"Valor NO valido",
							"Mensaje",
							JOptionPane.ERROR_MESSAGE);
				}
			} while (!validValue);
						
			if (optionConvertorSelected.toString() == "Conversor Monedas") {
				List<String> optionCurrencyList = new ArrayList<String>();
				optionCurrencyList.add("COP a Dolares");
				optionCurrencyList.add("COP a Euros");
				optionCurrencyList.add("COP a Libras");
				optionCurrencyList.add("COP a Yen-Japones");
				optionCurrencyList.add("COP a Won-Sur-Coreano");
				optionCurrencyList.add("Dolares a COP");
				optionCurrencyList.add("Euros a COP");
				optionCurrencyList.add("Libras a COP");
				optionCurrencyList.add("Yen-Japones a COP");
				optionCurrencyList.add("Won-Sur-Coreano a COP");
				Object[] optionsCurrency = optionCurrencyList.toArray();
				Object optionCurrencySelected = JOptionPane.showInputDialog(null, 
				                                           "Seleccione una opcion de Conversor", 
				                                           "Conversor", 
				                                            JOptionPane.PLAIN_MESSAGE, 
				                                            null,
				                                            optionsCurrency, 
				                                            optionsCurrency[0]);
				
				System.out.println(optionCurrencySelected);
				
//				Si se da cancelar o cerrar en la app, entonces cerramos el ciclo y por ende la app
				if (optionCurrencySelected == null) {
					break;
				}
				
				getConverterResult(optionCurrencySelected, valueToConvert);
			}
			
			else if (optionConvertorSelected.toString() == "Conversor Temperatura") {
				List<String> optionTemperatureList = new ArrayList<String>();
				optionTemperatureList.add("°C a °F");
				optionTemperatureList.add("°C a °K");
				optionTemperatureList.add("°F a °C");
				optionTemperatureList.add("°F a °K");
				optionTemperatureList.add("°K a °C");
				optionTemperatureList.add("°K a °F");
				Object[] optionsTemperature = optionTemperatureList.toArray();
				Object optionsTemperatureSelected = JOptionPane.showInputDialog(null, 
				                                           "Seleccione una opcion de Conversor", 
				                                           "Conversor", 
				                                            JOptionPane.PLAIN_MESSAGE, 
				                                            null,
				                                            optionsTemperature, 
				                                            optionsTemperature[0]);
				
				System.out.println(optionsTemperatureSelected);
				
//				Si se da cancelar o cerrar en la app, entonces cerramos el ciclo y por ende la app
				if (optionsTemperatureSelected == null) {
					break;
				}
				
				getConverterResult(optionsTemperatureSelected, valueToConvert);
			}
			
			int optionContinue = JOptionPane.showConfirmDialog(null,
										"Desea Continuar?",
										"Fin del Conversor",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
			
			System.out.println(optionContinue); // 0 == Si, 1 == No
			
			if (optionContinue == 1) {
				continueConverter = false;
				
				JOptionPane.showMessageDialog(null,
						"Programa Finalizado",
						"Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			}		
		}
	}
	
    public static boolean onlyDigits(String str) {
        // Regex to check string
        // contains only digits
        String regex = "[0-9]+";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }
 
        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(str);
 
        // Return if the string
        // matched the ReGex
        return m.matches();
    }
       
    public static void getConverterResult(Object optionConversionSelected, Object valueToConvert) {
    	double dolarValueToday = 4816.30;
		double euroValueToday = 5100.65;
		double libraValueToday = 5751.77;
		double yenValueToday = 35.21;
		double wonValueToday = 3.67;
		
		double resultConverted = 0;
		double toConvert = Double.parseDouble(valueToConvert.toString());
    	
//		Currency Conversions
    	if (optionConversionSelected == "COP a Dolares") {
    		resultConverted = toConvert/dolarValueToday;
    	}
    	if (optionConversionSelected == "COP a Euros") { 		
    		resultConverted = toConvert/euroValueToday;
    	}
    	if (optionConversionSelected == "COP a Libras") {    		
    		resultConverted = toConvert/libraValueToday;
    	}
    	if (optionConversionSelected == "COP a Yen-Japones") {    		
    		resultConverted = toConvert/yenValueToday;
    	}
    	if (optionConversionSelected == "COP a Won-Sur-Coreano") {    		
    		resultConverted = toConvert/wonValueToday;
    	}
    	if (optionConversionSelected == "Dolares a COP") {    		
    		resultConverted = toConvert*dolarValueToday;
    	}
    	if (optionConversionSelected == "Euros a COP") {    		
    		resultConverted = toConvert*euroValueToday;
    	}
    	if (optionConversionSelected == "Libras a COP") {    		
    		resultConverted = toConvert*libraValueToday;
    	}
    	if (optionConversionSelected == "Yen-Japones a COP") {    		
    		resultConverted = toConvert*yenValueToday;
    	}
    	if (optionConversionSelected == "Won-Sur-Coreano a COP") {    		
    		resultConverted = toConvert*wonValueToday;
    	}
    	
//    	Temperature Conversions
    	if (optionConversionSelected == "°C a °F") {    		
    		resultConverted = toConvert *(9/5) + 32;
    	}
    	if (optionConversionSelected == "°C a °K") {    		
    		resultConverted = toConvert + 273.15;
    	}
    	if (optionConversionSelected == "°F a °C") {    		
    		resultConverted = (toConvert - 32) * (5/9);
    	}
    	if (optionConversionSelected == "°F a °K") {    		
    		resultConverted = (toConvert - 32) * (5/9) + 273.15;
    	}
    	if (optionConversionSelected == "°K a °C") {    		
    		resultConverted = toConvert - 273.15;
    	}
    	if (optionConversionSelected == "°K a °F") {    		
    		resultConverted = (toConvert - 273.15) * (9/5) + 32;
    	}
    	
//    	Despliegue de Resultado
    	System.out.println(resultConverted);
    	
    	String toConvertUnit = optionConversionSelected.toString().split(" ")[0];
    	String convertedUnit = optionConversionSelected.toString().split(" ")[optionConversionSelected.toString().split(" ").length - 1];
    	
    	JOptionPane.showMessageDialog(null,
									valueToConvert + " " + toConvertUnit + " equivalen a " + String.format("%.2f", resultConverted) + " " + convertedUnit,
									"Resultado Conversion",
									JOptionPane.INFORMATION_MESSAGE);
    }
}
