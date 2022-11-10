class Main {

    public static void main(String[] args) {
        int[] bienes = { 6,3,2,1,4,2};
        System.out.println(hayRepartoEquitativo(bienes));
    }

    public static boolean hayRepartoEquitativo(int[] bienes) {
        int suma = 0;
        for (int i = 0; i < bienes.length; i++)
            suma = suma + bienes[i];
        if (suma % 3 == 0) { // podemos saber de antemano que no es posible el reparto equitativo
            Booleano exito = new Booleano(false);
            int[] falta = { suma / 3, suma / 3, suma / 3 };
            hayRepartoEquitativoAux(bienes, 0, falta, exito);
            return exito.getValor();
        } else
            return false;
    }

    public static void hayRepartoEquitativoAux(int[] bienes, int obj, int[] falta, Booleano exito) {
        if (obj == bienes.length) {
            if (falta[0] == falta[1] && falta[1] == falta[2])
                exito.setValor(true);
        } else {
            int c = 0;
            while ((c < 3) && !exito.getValor()) {
                if (bienes[obj] <= falta[c]) { // podemos asignarle el bien al heredero k.
                    falta[c] = falta[c] - bienes[obj];
                    obj++;
                    hayRepartoEquitativoAux(bienes, obj, falta, exito);
                    if (!exito.getValor()) {
                        obj--;
                        falta[c] = falta[c] + bienes[obj];
                    }
                }
                c++;
            }
        }
    }

}
