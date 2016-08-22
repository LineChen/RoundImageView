# RoundImageView

自定义圆角ImageView和圆形ImageView。

**圆形图片**

 - borderWidth	边框宽度
 - borderColor 	边框颜色

**圆角图片**

 - borderWidth	边框宽度
 - borderColor 	边框颜色
 - leftTopRadius	左上角圆角半径
 - rightTopRadius	右上角圆角半径
 - rightBottomRadius	右下角圆角半径
 - leftBottomRadius		左下角圆角半径

#### 使用

```java
<com.beiing.roundimage.CircleImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:scaleType="centerCrop"
        android:src="@mipmap/head"
        app:borderWidth="2dp"
        app:borderColor="#8c9eff"
        />

```


```java
 <com.beiing.roundimage.RoundImageView
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:scaleType="centerCrop"
                android:src="@mipmap/test"
                app:borderWidth="2dp"
                app:borderColor="#8c9eff"
                app:leftTopRadius="10dp"
                app:rightTopRadius="30dp"
                app:rightBottomRadius="10dp"
                app:leftBottomRadius="30dp"
                />

```

![screenshot](http://)















