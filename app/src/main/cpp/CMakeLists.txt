
cmake_minimum_required(VERSION 3.4.1)

include_directories(include)

add_library(
        native-lib
        SHARED
        native-lib.cpp
        DetectionBasedTracker_jni.cpp
)

add_library( opencv_java4
        SHARED
        IMPORTED)

set_target_properties(  opencv_java4
        PROPERTIES IMPORTED_LOCATION
        ../../../../libs/arm64-v8a/libopencv_java4.so)


include_directories(detection)

find_library(
        log-lib
        log
        android-lib
        android)



target_link_libraries(
                       native-lib
        opencv_java4
                        android
                       ${log-lib} )