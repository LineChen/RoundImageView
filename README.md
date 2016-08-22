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

 #####  布局

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


##### 测试常见的图片加载库加载

- Glide

```java
 circleImageViewGlide = (CircleImageView) findViewById(R.id.circle_image_glide);
 Glide.with(this).load("http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg").into(circleImageViewGlide);

```

- Picasso

```java
roundImageViewPicasso = (RoundImageView) findViewById(R.id.round_image_picasso);
 Picasso.with(this).load("http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg").fit().into(roundImageViewPicasso);

```

- xUtils3

```java
roundImageViewXutils = (RoundImageView) findViewById(R.id.round_image_xutils);
x.image().bind(roundImageViewXutils, "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
                new ImageOptions.Builder().setCrop(true).build());

```


#### 效果图

![screenshot](https://github.com/LineChen/RoundImageView/blob/master/screenshot/screenshot.png)















