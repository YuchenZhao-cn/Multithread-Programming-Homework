#include "HelloWorld.h"
//HelloWorld.c

#include "jni.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_HelloWorld_cfunction
(JNIEnv*, jobject)
{
    printf("\n > C says HelloWorld !\n");
}