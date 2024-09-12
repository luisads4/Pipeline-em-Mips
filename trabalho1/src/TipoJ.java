public class TipoJ {
    Registrador registrador;
    public TipoJ() {
        this.registrador = new Registrador();
    }
    //opcode|immediate
    public String converteTipoJ(int immediate){
        String instrucaoBinario = String.format("%26s", Integer.toBinaryString(immediate)).replace(' ', '0');
        return instrucaoBinario;
    }
}
