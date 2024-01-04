#include<stdio.h>

int main(){
	int i,j,temp,n;
	printf("nhap do dai cua du lieu: ");
	scanf("%d",&n);
	int a[n];
	printf("\nnhap %d gia tri:\n",n);
	
	for (i=0;i<n;i++)
	printf("so thu tu: ");
	scanf("%d",&a[i]);
	
	for (i=0;i<n;i++){
		for (j=0;j<n;j++){
			if(a[i] < a[j]){
				int temp = a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	printf("sau khi sap xep:\n");
	for (i=0;i<n;i++){
		printf(" %d ",a[i]);
	}
	return 0;
} 
