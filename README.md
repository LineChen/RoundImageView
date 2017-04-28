# RoundImageView

圆形图片和可控位置圆角图片

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

## 使用
添加依赖到项目中.


##### 布局

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



#License

```
   Copyright (C) 2016 LineChen <15764230067@163.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```











