/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_zeromq_zyre_Zyre */

#ifndef _Included_org_zeromq_zyre_Zyre
#define _Included_org_zeromq_zyre_Zyre
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __init
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_zeromq_zyre_Zyre__1_1init
  (JNIEnv *, jclass, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1destroy
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __uuid
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_zeromq_zyre_Zyre__1_1uuid
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __name
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_zeromq_zyre_Zyre__1_1name
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __shout
 * Signature: (JLjava/lang/String;J)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1shout
  (JNIEnv *, jclass, jlong, jstring, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __whisper
 * Signature: (JLjava/lang/String;J)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1whisper
  (JNIEnv *, jclass, jlong, jstring, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __start
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_zeromq_zyre_Zyre__1_1start
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __stop
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1stop
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __join
 * Signature: (JLjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_zeromq_zyre_Zyre__1_1join
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __leave
 * Signature: (JLjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_zeromq_zyre_Zyre__1_1leave
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __zyre_recv
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_zeromq_zyre_Zyre__1_1zyre_1recv
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __set_header
 * Signature: (JLjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1set_1header
  (JNIEnv *, jclass, jlong, jstring, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __set_verbose
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1set_1verbose
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __set_endpoint
 * Signature: (JLjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_zeromq_zyre_Zyre__1_1set_1endpoint
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __gossip_bind
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1gossip_1bind
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __dump
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1dump
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __own_groups
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_zeromq_zyre_Zyre__1_1own_1groups
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __peers
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_zeromq_zyre_Zyre__1_1peers
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __gossip_connect
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1gossip_1connect
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __peer_groups
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_zeromq_zyre_Zyre__1_1peer_1groups
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __peer_header_value
 * Signature: (JLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_zeromq_zyre_Zyre__1_1peer_1header_1value
  (JNIEnv *, jclass, jlong, jstring, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __shouts
 * Signature: (JLjava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_zeromq_zyre_Zyre__1_1shouts
  (JNIEnv *, jclass, jlong, jstring, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __whispers
 * Signature: (JLjava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_zeromq_zyre_Zyre__1_1whispers
  (JNIEnv *, jclass, jlong, jstring, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __peerAddress
 * Signature: (JLjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_zeromq_zyre_Zyre__1_1peerAddress
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __set_interface
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1set_1interface
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __set_port
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1set_1port
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_zeromq_zyre_Zyre
 * Method:    __set_interval
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_zeromq_zyre_Zyre__1_1set_1interval
  (JNIEnv *, jclass, jlong, jlong);

#ifdef __cplusplus
}
#endif
#endif
