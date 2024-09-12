public class Registrador {
    public String registradorBinario(String registrador){
        String registradorBinario = "00000";

        if (registrador.equals("$zero") || registrador.equals("$r0") ) { //R0
            registradorBinario = "00000";
        }

        else if (registrador.equals("$at")) {   //R1
            registradorBinario = "00001";
        } else if (registrador.equals("$v0")) { //R2
            registradorBinario = "00010";
        } else if (registrador.equals("$v1")) { //R3
            registradorBinario = "00011";
        } else if (registrador.equals("$a0")) { //R4
            registradorBinario = "00100";
        } else if (registrador.equals("$a1")) { //R5
            registradorBinario = "00101";
        } else if (registrador.equals("$a2")) { //R6
            registradorBinario = "00110";
        } else if (registrador.equals("$a3")) { //R7
            registradorBinario = "00111";
        }

        //$t..
        else if (registrador.equals("$t0")) {   //R8
            registradorBinario = "01000";
        } else if (registrador.equals("$t1")) { //R9
            registradorBinario = "01001";
        } else if (registrador.equals("$t2")) { //R10
            registradorBinario = "01010";
        } else if (registrador.equals("$t3")) { //R11
            registradorBinario = "01011";
        } else if (registrador.equals("$t4")) { //R12
            registradorBinario = "01100";
        } else if (registrador.equals("$t5")) { //R13
            registradorBinario = "01101";
        } else if (registrador.equals("$t6")) { //R14
            registradorBinario = "01110";
        } else if (registrador.equals("$t7")) { //R15
            registradorBinario = "01111";
        }
        //$s..
        else if (registrador.equals("$s0")) {   //R16
            registradorBinario = "10000";
        } else if (registrador.equals("$s1")) { //R17
            registradorBinario = "10001";
        } else if (registrador.equals("$s2")) { //R18
            registradorBinario = "10010";
        } else if (registrador.equals("$s3")) { //R19
            registradorBinario = "10011";
        } else if (registrador.equals("$s4")) { //R20
            registradorBinario = "10100";
        } else if (registrador.equals("$s5")) { //R21
            registradorBinario = "10101";
        } else if (registrador.equals("$s6")) { //R22
            registradorBinario = "10110";
        } else if (registrador.equals("$s7")) { //R23
            registradorBinario = "10111";
        }
        else if (registrador.equals("$t8")) {   //R24
            registradorBinario = "11000";
        } else if (registrador.equals("$t9")) { //R25
            registradorBinario = "11001";
        } else if (registrador.equals("$k0")) { //R26
            registradorBinario = "11010";
        } else if (registrador.equals("$k1")) { //R27
            registradorBinario = "11011";
        } else if (registrador.equals("gp")) { //R28
            registradorBinario = "11100";
        } else if (registrador.equals("$sp")) { //R29
            registradorBinario = "11101";
        } else if (registrador.equals("$s8")) { //R30
            registradorBinario = "11110";
        } else if (registrador.equals("$ra")) { //R31
            registradorBinario = "11111";
        }

        return registradorBinario;
    }
}
