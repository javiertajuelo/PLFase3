package Impresiones;

import java.util.HashMap;
import java.util.Map;

import asint.SintaxisAbstractaEval;

public class Imp_recursiva extends SintaxisAbstractaEval {
	public class ECteNoDefinida extends RuntimeException {
        public ECteNoDefinida(String msg) {
            super(msg);
        }
    }
    public class ECteDuplicada extends RuntimeException {
        public ECteDuplicada(String msg) {
            super(msg);
        }
    }
    private Map<String,Float> env;
    
    public Imp_recursiva() {
        this.env = new HashMap<>();
    }
    
    public float evalua(Prog n) {
    	evalDecs(n.dcs);
    	L_Instrucciones(n.insts);
    }
    
    private void evalDecs(DeclaracionesConSep d) {
    	if(claseDe()) {
    		
    	}
    }

    
}
