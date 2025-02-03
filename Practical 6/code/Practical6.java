class Practical6{
void pattern1(){
int size = 3;
for(int i =1 ; i<=size ; i++){
	for(int space=size-i ; space>0;space--){
	System.out.print(" ");
	}

	for(int j=2*i-1 ;j>0;j--){
	System.out.print("+");
	}
	System.out.println();
   }

for (int i = size - 1; i >= 1; i--) {
            for (int space = size - i; space > 0; space--) {
                System.out.print(" ");
            }
            for (int symb = 2 * i - 1; symb > 0; symb--) {
                System.out.print("+");
            }
            System.out.println();
        }

}


void pattern2(){
int size = 3;
for(int i =1 ; i<=size ; i++){
	for(int space=size-i ; space>0;space--){
	System.out.print(" ");
	}
	
	for(int j=2*i-1 ;j>0;j--){
	if(j%2==0){
	System.out.print(" ");
	}
	else{
	System.out.print("+");
	}
	}
	System.out.println();
   }

for (int i = size - 1; i >= 1; i--) {
        for (int space = size - i; space > 0; space--) {
        System.out.print(" ");
         }
       for (int symb = 2 * i - 1; symb > 0; symb--) {
       	if(symb%2==0){
	System.out.print(" ");
	}
	else{
	System.out.print("*");
	}
	}
            System.out.println();
        }

}




void pattern3(){
int size = 3;
int count=0;
for(int i =1 ; i<=size ; i++){
	for(int space=size-i ; space>0;space--){
	System.out.print(" ");
	}
	
	for(int j=2*i-1 ;j>0;j--){
	count+=1;
	if(count%2==0){
	System.out.print("+");
	}
	else{
	System.out.print("*");
	}
	}
	System.out.println();
   }
    count =0;
for (int i = size ; i >= 1; i--) {
        for (int space = size - i; space > 0; space--) {
        System.out.print(" ");
         }
       for (int symb = 2 * i - 1; symb > 0; symb--) {
	count+=1;
       	if(count%2==0){
	System.out.print("*");
	}
	else{
	System.out.print("+");
	}
	}
            System.out.println();
        }

}
public static void main(String args[]){
Pratical6 p = new Pratical6();
p.pattern1();
p.pattern2();
p.pattern3();
}

}

