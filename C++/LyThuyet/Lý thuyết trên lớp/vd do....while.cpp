#include <stdio.h>
int main (){
	int op, a, b;
	do{
		printf("\n===menu===");
		printf("\n1. cong ");
		printf("\n2. tru ");
		printf("\n3. exit");
		printf("\nlua chon(1-3): ");
		scanf("%d",&op);
		switch(op){
			case 1:
				printf("nhap vao hai so : ");
				scanf("%d%d", &a, &b);
				printf("\n%d + %d = %d",a,b,a + b);
				break;
			case 2:
				printf("\n nhap vao hai so :");
					scanf("%d%d",&a,&b);
				printf("\n%d - %d = %d",a,b,a-b);
			
				break;
			case 3:
		    	printf("\nbye!");
		    	return 0;
		    	break;
			default:
				printf("\n ban phai chon tu 1-3");
 		}
	}while(op >=1 && op <= 3);
}
