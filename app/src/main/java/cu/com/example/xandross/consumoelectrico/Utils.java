package cu.com.example.xandross.consumoelectrico;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alejandro on 21/08/2015.
 */
public class Utils {

    /* Calcula el promedio de consumo diario segun el consumo total
     * y los dias leidos
     * @pConsumo: consumo en Kwh en lso dias especificados
     * @pDiasLeidos: Dias para los cuales ocurrio el consumo leido
     * */
    public static Double calcularPromedioConsumoDiario(int pConsumo, int pDiasLeidos) {
        if (pDiasLeidos > 0) {
            return (double) pConsumo / pDiasLeidos;
        } else return 0.0;
    }


    /* Calcula el posible importe a pagar 30 dias despues de la lectura inicial
    * en caso de que se amntenga estable el PROMEDIO diario de \consumo segun ritmo actual
    * a partir de los dias leidos y el consumo diario promedio
    * @pConsumo: consumo en Kwh en lso dias especificados
    * @pDiasLeidos: Dias para los cuales ocurrio el consumo leido
    * */
    public static Double predecirImporteFinalMes(int pConsumo, int pDiasLeidos) {
        if (pDiasLeidos > 0) {
            return calcularImporteTotal((int) (calcularPromedioConsumoDiario(pConsumo, pDiasLeidos) * 30));
        } else return 0.0;
    }

    public static Double calcularImporteTotal(int pConsumo) {

        if (pConsumo <= 100) {
            return pConsumo * 0.09;
        } else if ((pConsumo >= 101) && (pConsumo <= 150)) {
           return (pConsumo - 100) * 0.3 + 9;
        } else if ((pConsumo >= 151) && (pConsumo <= 200)) {
            return (pConsumo - 150) * 0.4 + 24;
        } else if ((pConsumo >= 201) && (pConsumo <= 250)) {
            return (pConsumo - 200) * 0.6 + 44;
        } else if ((pConsumo >= 251) && (pConsumo <= 300)) {
            return (pConsumo - 250) * 0.8 + 74;
        } else if ((pConsumo >= 301) && (pConsumo <= 350)) {
            return (pConsumo - 300) * 1.5 + 114;
        } else if ((pConsumo >= 351) && (pConsumo <= 500)) {
            return (pConsumo - 350) * 1.8 + 189;
        } else if ((pConsumo >= 501) && (pConsumo <= 1000)) {
            return (pConsumo - 500) * 2.0 + 459;
        } else if ((pConsumo >= 1001) && (pConsumo <= 5000)) {
            return (pConsumo - 1000) * 3.0 + 1459;
        } else if (pConsumo > 5001) {
            return (pConsumo - 5000) * 5.0 + 13459;
        } else return 0.00;

    }

    public static int DaysBetweenDates(final Date newDate, final Date oldDate) {
        long millisecondsDif = newDate.getTime() - oldDate.getTime();
        long days = millisecondsDif / (1000 * 60 * 60 * 24);
        return (int) days;
    }

    public static String formatDate(String date, String initDateFormat, String endDateFormat) throws java.text.ParseException {
        Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
        SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
       // String parsedDate = formatter.format(initDate);

        return formatter.format(initDate);
    }
}
