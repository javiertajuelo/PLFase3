package c_ast_ascendente;

import java_cup.runtime.ComplexSymbolFactory;

public class UnidadLexica extends ComplexSymbolFactory.ComplexSymbol {
   public static class StringLocalizado {
      private int fila;
      private int col;
      private String s;
      public StringLocalizado(String s, int fila, int col) {
          this.s = s;
          this.fila = fila;
          this.col = col;  
      }
      public int fila() { return fila; }
      public int col() { return col; }
      public String str() { return s; }
      @Override
      public String toString() {
          return s;
      }
   }

   // Llama al constructor de ComplexSymbol: (int sym, int left, int right, Object value)
   public UnidadLexica(int fila, int columna, int clase, String lexema) {
      super(lexema, clase, new StringLocalizado(lexema, fila, columna));
   }

   public int clase() { return sym; }
   public int fila() { return ((StringLocalizado)value).fila(); }
   public int columna() { return ((StringLocalizado)value).col(); }
   public String lexema() { return ((StringLocalizado)value).str(); }

   @Override
   public String toString() {
       return lexema() + " [" + fila() + ", " + columna() + "]";
   }
}
