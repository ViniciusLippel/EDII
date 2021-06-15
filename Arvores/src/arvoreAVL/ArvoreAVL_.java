/*package arvoreAVL;
//import java.util.*;
public class ArvoreAVL_ {
    private static class ARVORE {
        public int num, altd, alte;
        public ARVORE dir, esq;
   }
    
    public static ARVORE inserir(ARVORE aux, int num) {
        // o objeto novo é um objeto auxiliar
        ARVORE novo;
        if (aux == null) {
            novo = new ARVORE();
            novo.num = num;
            novo.altd = 0;
            novo.alte = 0;
            novo.esq = null;
            novo.dir = null;
            aux = novo;
        } else if (num < aux.num) {
            aux.esq = inserir(aux.esq, num);
            if (aux.esq.altd > aux.esq.alte) {
                aux.alte = aux.esq.altd + 1;
            } else {
                aux.alte = aux.esq.alte + 1;
            }
            aux = balanceamento(aux);
        } else {
            aux.dir = inserir(aux.dir, num);
            if (aux.dir.altd > aux.dir.alte) {
                aux.altd = aux.dir.altd + 1;
            } else {
                aux.altd = aux.dir.alte + 1;
            }
            aux = balanceamento(aux);
        }
        return aux;
    }
    public static ARVORE balanceamento(ARVORE aux) {
        int d, df;
        d = aux.altd - aux.alte;
        if (d == 2) {
            df = aux.dir.altd - aux.dir.alte;
            if (df >= 0) {
                aux = rotacao_esquerda(aux);
            } else {
                aux.dir = rotacao_direita(aux.dir);
                aux = rotacao_esquerda(aux);
            }
        } else if (d == -2) {
            df = aux.esq.altd - aux.esq.alte;
            if (df <= 0) {
                aux = rotacao_direita(aux);
            } else {
                aux.esq = rotacao_esquerda(aux.esq);
                aux = rotacao_direita(aux);
            }
        }
        return aux;
    }
    
    public static ARVORE rotacao_esquerda(ARVORE aux) {
        ARVORE aux1, aux2;
        aux1 = aux.dir;
        aux2 = aux1.esq;
        aux.dir = aux2;
        aux1.esq = aux;
        if (aux.dir == null) {
            aux.altd = 0;
        } else if (aux.dir.alte > aux.dir.altd) {
            aux.altd = aux.dir.alte + 1;
        } else {
            aux.altd = aux.dir.altd + 1;
        }
        if (aux1.esq.alte > aux1.esq.altd) {
            aux1.alte = aux1.esq.alte + 1;
        } else {
            aux1.alte = aux1.esq.altd + 1;
        }
        return aux1;
    }

    public static ARVORE rotacao_direita(ARVORE aux) {
        ARVORE aux1, aux2;
        aux1 = aux.esq;
        aux2 = aux1.dir;
        aux.esq = aux2;
        aux1.dir = aux;
        if (aux.esq == null) {
            aux.alte = 0;
        } else if (aux.esq.alte > aux.esq.altd) {
            aux.alte = aux.esq.alte + 1;
        } else {
            aux.alte = aux.esq.altd + 1;
        }
        if (aux1.dir.alte > aux1.dir.altd) {
            aux1.altd = aux1.dir.alte + 1;
        } else {
            aux1.altd = aux1.dir.altd + 1;
        }
        return aux1;
    }

    public static void exibiremordem(ARVORE aux) {
        if (aux != null) {
            exibiremordem(aux.esq);
            System.out.print(aux.num + "  ");
            exibiremordem(aux.dir);
        }
    }
    
    public static boolean verificar_avl(ARVORE aux) {
    	boolean b = true;
    	if((aux.altd-aux.alte <2 && aux.altd-aux.alte>-2)) {
    		if(aux.dir != null)
    			b = b && verificar_avl(aux.dir);
    		if(aux.esq != null)
    			b = b && verificar_avl(aux.esq);
    	}
    	else
    		b = false;
    	
    	return b;
    }
    
    public static ARVORE maisEsquerda(ARVORE aux) {
    	if (aux.esq != null)
    		return maisEsquerda(aux.esq);
    	return aux;
    }
    
    public static ARVORE maisDireita(ARVORE aux) {
    	if (aux.dir != null)
    		return maisEsquerda(aux.dir);
    	return aux;
    }
    
    //public static int
    
    public static ARVORE deletar(ARVORE aux, int num) {
    	if(aux != null) {
    		if (aux.num == num) {
    			if (aux.dir != null && aux.esq != null) {
    				int sucessor = maisEsquerda(aux.dir).num;
    				aux = deletar(aux, sucessor);
    				aux.num = sucessor;
    			}
    			else if (aux.dir != null) {
    				int sub = aux.dir.num;
    				aux = deletar(aux.dir, sub);
    				aux.num = sub;
    			}
    			else if (aux.esq != null) {
    				int sub = aux.esq.num;
    				aux = deletar(aux.esq, sub);
    				aux.num = sub;
    			}
    			else {
    				
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
        ARVORE a = null;
        
        a = inserir(a, 10 );
        a = inserir(a, 4);
        a = inserir(a, 7);
        a = inserir(a, 8);
        a = inserir(a, 2);
        a = inserir(a, 3);
        a = inserir(a, 9);


    //    exibirpreordem(a);
        exibiremordem(a);
        System.out.println(verificar_avl(a));
     
    }
}*/