public class Conversor {
    private Registrador registrador;
    private TipoR tipoR;
    private TipoI tipoI;
    private TipoJ tipoJ;

    public Conversor() {
        this.registrador = new Registrador();
        this.tipoR = new TipoR();
        this.tipoI = new TipoI();
        this.tipoJ = new TipoJ();
    }

    public String converter(String instrucao[]){
        String inst = instrucao[0];//op code
        String instrucaoBinario = "";
        //tipo R - opcode|rs|rt|rd|shamt|function
        //LÓGICAS E ARITMÉTICAS
        if(inst.equals("add")){
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 32);

        } else if (inst.equals("addu")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 33);

        } else if (inst.equals("sub")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 34);

        } else if (inst.equals("subu")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 35);

        } else if (inst.equals("and")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 36);

        } else if (inst.equals("or")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 37);

        } else if (inst.equals("xor")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 38);

        } else if (inst.equals("not")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 39);

        } else if (inst.equals("slt")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 42);

        } else if (inst.equals("sltu")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[2], instrucao[3], instrucao[1], 0, 43);

        }

        //INSTRUÇÕES DE DESLOCAMENTO DE BITS
        else if (inst.equals("sll")) {
            instrucaoBinario= tipoR.converteTipoR(0, "0", instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]), 0);

        } else if (inst.equals("srl")) {
            instrucaoBinario= tipoR.converteTipoR(0, "0", instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]), 2);

        } else if (inst.equals("sra")) {
            instrucaoBinario= tipoR.converteTipoR(0, "0", instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]), 3);

        } else if (inst.equals("sllv")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[3], instrucao[2], instrucao[1],0, 4);

        } else if (inst.equals("srlv")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[3], instrucao[2], instrucao[1],0, 6);

        } else if (inst.equals("srav")) {
            instrucaoBinario= tipoR.converteTipoR(0, instrucao[3], instrucao[2], instrucao[1],0, 7);

        }

        //INSTRUÇÕE DE MULTIPLICAÇÃO E DIVISÃO
        else if (inst.equals("mfhi")) {
            instrucaoBinario= tipoR.converteTipoR(0, "0", "0", instrucao[1], 0, 16);

        } else if (inst.equals("mthi")) {
            instrucaoBinario= tipoR.converteTipoR(0,instrucao[2], "0", "0", 0, 17);

        } else if (inst.equals("mflo")) {
            instrucaoBinario= tipoR.converteTipoR(0,"0", "0", instrucao[1], 0, 18);

        }else if (inst.equals("mtlo")) {
            instrucaoBinario= tipoR.converteTipoR(0,instrucao[2], "0", "0", 0, 19);

        } else if (inst.equals("mult")) {
            instrucaoBinario= tipoR.converteTipoR(0,instrucao[2], instrucao[3], "0", 0, 24);

        } else if (inst.equals("multu")) {
            instrucaoBinario= tipoR.converteTipoR(0,instrucao[2], instrucao[3], "0", 0, 25);

        } else if (inst.equals("div")) {
            instrucaoBinario= tipoR.converteTipoR(0,instrucao[2], instrucao[3], "0", 0, 26);

        } else if (inst.equals("divu")) {
            instrucaoBinario= tipoR.converteTipoR(0,instrucao[2], instrucao[3], "0", 0, 27);

        }

        //INSTRUÇÕES DE DESVIO
        else if (inst.equals("jr")) {
            instrucaoBinario= tipoR.converteTipoR(0,instrucao[1], "0", "0",0, 8);

        } else if (inst.equals("jalr")) {
            if (instrucao.length == 3) { //se tiver 2 registradores
                instrucaoBinario = tipoR.converteTipoR(0,instrucao[2], "0", instrucao[1], 0, 9);
            } else {
                instrucaoBinario = tipoR.converteTipoR(0,instrucao[1], "00000", "$ra", 0, 9);
            }

        }

        //tipo I - opcode|rs|rt|immediate
        //INSTRUÇÕES LOAD E STORE
        else if (inst.equals("lb")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(32)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("lh")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(33)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("lwl")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(34)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("lw")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(35)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("lbu")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(36)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("lhu")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(37)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("lwr")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(38)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("sb")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(40)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("sh")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(41)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("swl")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(42)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("sw")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(43)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        } else if (inst.equals("swr")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(46)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[3], instrucao[1], Integer.parseInt(instrucao[2]));

        }

        //INSTRUÇÕES LÓGICAS E ARITMÉTICAS
        else if (inst.equals("addi")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(8)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]));

        } else if (inst.equals("addiu")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(9)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]));

        } else if (inst.equals("slti")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(10)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]));

        } else if (inst.equals("sltiu")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(11)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]));

        } else if (inst.equals("andi")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(12)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]));

        } else if (inst.equals("ori")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(13)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]));

        } else if (inst.equals("xori")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(14)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[2], instrucao[1], Integer.parseInt(instrucao[3]));

        } else if (inst.equals("lui")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(15)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI("0", instrucao[1], Integer.parseInt(instrucao[3]));

        }

        //INSTRUÇÕES DE DESVIO
        else if (inst.equals("bltz")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(1)).replace(' ', '0');
            instrucaoBinario+= tipoI.tipoIDesvio(instrucao[1], 0, Integer.parseInt(instrucao[2]));

        } else if (inst.equals("bgez")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(1)).replace(' ', '0');
            instrucaoBinario+= tipoI.tipoIDesvio(instrucao[1], 1, Integer.parseInt(instrucao[2]));

        } else if (inst.equals("bltzal")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(1)).replace(' ', '0');
            instrucaoBinario+= tipoI.tipoIDesvio(instrucao[1], 16, Integer.parseInt(instrucao[2]));

        } else if (inst.equals("bgezal")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(1)).replace(' ', '0');
            instrucaoBinario+= tipoI.tipoIDesvio(instrucao[1], 17, Integer.parseInt(instrucao[2]));

        } else if (inst.equals("beq")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(4)).replace(' ', '0');
            System.out.println(instrucaoBinario);
            instrucaoBinario+= tipoI.converteTipoI(instrucao[1],instrucao[2] , Integer.parseInt(instrucao[3]));

        } else if (inst.equals("bne")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(5)).replace(' ', '0');
            instrucaoBinario+= tipoI.converteTipoI(instrucao[1],instrucao[2] , Integer.parseInt(instrucao[3]));

        } else if (inst.equals("blez")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(6)).replace(' ', '0');
            instrucaoBinario+= tipoI.tipoIDesvio(instrucao[1], 0, Integer.parseInt(instrucao[2]));

        } else if (inst.equals("bgtz")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(7)).replace(' ', '0');
            instrucaoBinario+= tipoI.tipoIDesvio(instrucao[1], 0, Integer.parseInt(instrucao[2]));

        }

        //tipo J - opcode|immediate
        //INSTRUÇÕES DE DESVIO
        else if (inst.equals("j")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(2)).replace(' ', '0');
            instrucaoBinario+= tipoJ.converteTipoJ(Integer.parseInt(instrucao[1]));

        } else if (inst.equals("jal")) {
            instrucaoBinario = String.format("%6s", Integer.toBinaryString(3)).replace(' ', '0');
            instrucaoBinario+= tipoJ.converteTipoJ(Integer.parseInt(instrucao[1]));

        }

        return instrucaoBinario;
    }
}
