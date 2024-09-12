public class TipoI {
    Registrador registrador;
    public TipoI() {
        this.registrador = new Registrador();
    }
    //opcode|rs|rt|immediate
    public String converteTipoI(String rs, String rt, int immediate){
        String instrucaoBinario = "";
        instrucaoBinario += registrador.registradorBinario(rs);
        instrucaoBinario += registrador.registradorBinario(rt);
        //converte para string no formato de 16bits e trata os numeros negativos
        instrucaoBinario += String.format("%16s", Integer.toBinaryString(immediate & 0xFFFF)).replace(' ', '0');
        return instrucaoBinario;
    }
    public String tipoIDesvio(String rs, int rt, int immediate){
        String instrucaoBinario = "";
        instrucaoBinario += registrador.registradorBinario(rs);
        instrucaoBinario += String.format("%5s", Integer.toBinaryString(rt)).replace(' ', '0');
        //converte para string no formato de 16bits e trata os numeros negativos
        instrucaoBinario += String.format("%16s", Integer.toBinaryString(immediate & 0xFFFF)).replace(' ', '0');
        return instrucaoBinario;
    }
}
