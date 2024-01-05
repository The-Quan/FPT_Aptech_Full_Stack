#include<stdio.h>
int main(){
	int temp,i,n,j;
	printf("nhap do dai du lieu: ");
	scanf("%d",&n);
	int a[n];
	printf("nhap %d gia tri: ",n);
	for (i=0;i<n;i++);
	scanf("%d",&a[i]);
	
	//selection sort
	for (i=0;i<n;i++){
		int min_index = i;
		for (j=i+1;j<n;j++){
			if (a[j]<a[min_index]){
				min_index = j;
			}
			if (min_index !=i){
			int temp;
			temp = a[i];
			a[i] = a[min_index];
			a[min_index]=temp;}
	 }
for (i=0;i<n;i++)
	printf("%d ",&a[i]);
	}
	return a[i];
}
