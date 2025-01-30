public class Practical5{	
  int factorialfor(int value){
  	if(value <= 2){
	return value;
	}
	else{
	int result=1;
	for(int i=2 ;i<= value;i++){
	result = result*i;
        }
	return result;
        }
        }

  int factorialwhile(int value){
	if(value <= 2){
        return value;
        }
	else{
	int result=1;
	int i=2;
	while(i <= value){
	result = result*i;
	i++;
	}
	return result;
	}
	}

  long factorialwithoutloop(int value){
        if(value <= 2){
        return value;
        }
        else{
        long result = value* factorialwithoutloop(value-1);
        return result;
        }
	}

  int sumarrfor(int [] arr){
	if(arr.length == 1)
	return arr[0];
	else{
	int sum =0 ;
	for(int i=0 ;i<arr.length;i++){
	sum+= arr[i];
	}
	return sum;
	}	
	}

  int sumarrwhile(int[] arr){
	if(arr.length == 0)
	return arr[0];
	else{
	int i = 0;
	int result=0;
	while (i < arr.length){
	result+=arr[i];
	i++;
	}
	return result;
	}
	}


  int sumarrwithoutloop(int[] arr,int index){
	if(arr.length == 0||index == 0)
        return arr[0];
	else{
	int result = arr[index] + sumarrwithoutloop(arr ,index-1);
	return result;
	}
}

	public static void main(String args[]){
		Practical5 p = new Practical5();
		System.out.println("using for loop :");
		int result = p.factorialfor(4);
		System.out.println(result);

		System.out.println("using while loop :");
                int result1 = p.factorialwhile(3);
                System.out.println(result1);

		System.out.println("without using loop :");
                long result2 = p.factorialwithoutloop(15);
                System.out.println(result2);

		System.out.println("sum of array using for loop");
		int[] arr = {10,20,45,66,77};
		int result3 = p.sumarrfor(arr);
		System.out.println(result3);

		System.out.println("sum of array using while loop");
                int result4 = p.sumarrwhile(arr);
                System.out.println(result4);

		System.out.println("sum of array without using loop");
		int index = arr.length-1;
                int result5 = p.sumarrwithoutloop(arr,index);
                System.out.println(result5);
		
 }
}
