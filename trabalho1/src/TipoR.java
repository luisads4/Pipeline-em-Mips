public class TipoR {
    Registrador registrador;
    public TipoR() {
        this.registrador = new Registrador();
    }
    //opcode|rs|rt|rd|shamt|function
    public String converteTipoR(int opcode, String rs, String rt, String rd, int shamt, int function){
        String instrucaoBinario =String.format("%6s", Integer.toBinaryString(opcode)).replace(' ', '0'); //opcode
        instrucaoBinario += registrador.registradorBinario(rs);
        instrucaoBinario += registrador.registradorBinario(rt);
        instrucaoBinario += registrador.registradorBinario(rd);
        //converte para string no formato de 5 e 6 bits
        instrucaoBinario += String.format("%5s", Integer.toBinaryString(shamt)).replace(' ', '0');
        instrucaoBinario += String.format("%6s", Integer.toBinaryString(function)).replace(' ', '0');
        return instrucaoBinario;
    }
}
