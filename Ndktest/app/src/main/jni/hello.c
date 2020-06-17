//引入上面生成的头文件，并实现头文件中声明的方法
#include "com_qian_NativeCaller.h"
#include <stdio.h>
#include <sys/time.h>
#include <unistd.h>
#include<time.h>   //用到clock()函数
JNIEXPORT jint JNICALL Java_com_qian_NativeCaller_getStringFromNative(JNIEnv *env, jobject obj){

    for(double i = 0; i < 10000000000; i++){
        float n = 10200, n2 = 3455454, n3;
        n3 = n2 + n;
    }

    return 0;
}

