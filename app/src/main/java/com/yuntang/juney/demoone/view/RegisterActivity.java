package com.yuntang.juney.demoone.view;

import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.presenter.RegisterPresenter;
import com.yuntang.juney.demoone.utils.ImageCompress;
import com.yuntang.juney.demoone.utils.Mac;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * 用户注册功能
 */
public class RegisterActivity extends AppCompatActivity implements RegisterView, View.OnClickListener {

    SharedPreferences preferences = null;    //声明SharedPreferences的对象
    private ImageView headLink;
    private EditText uid;
    private EditText password;
    private EditText realName;
    private EditText mobile;
    private EditText birth;
    private EditText email;
    private EditText address;
    private Button btnRegister;
    RegisterPresenter registerPresenter;

    final int CHOOSE_PICTURE = 0;     //选择照片功能编码
    final int TAKE_PHOTO = 1;      //拍照编码
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

    }

    /**
     * 初始化组件
     */
    private void initViews() {

        headLink = (ImageView) findViewById(R.id.headLink);
        uid = (EditText) findViewById(R.id.uid);
        password = (EditText) findViewById(R.id.password);
        realName = (EditText) findViewById(R.id.realName);
        mobile = (EditText) findViewById(R.id.mobile);
        birth = (EditText) findViewById(R.id.birth);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);     //注册按钮点击
        headLink.setOnClickListener(this);       //头像按钮点击
        registerPresenter = new RegisterPresenter(this);
    }


    @Override
    public void onClick(View view) {   //点击事件
        switch (view.getId()) {
            case R.id.btnRegister:
                registerPresenter.doRegister();
                break;
            case R.id.headLink:
                showChoosePicDialog();
                break;
        }
    }

    @Override
    public String getMac() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Mac mac = new Mac();
        return mac.GenerateRandom(preferences);
    }

    @Override
    public String getUid() {     //从当前视图获取用户名
        return uid.getText().toString().trim();
    }

    @Override
    public String getRealName() {    //从当前视图获取真实姓名
        return realName.getText().toString().trim();
    }

    @Override
    public String getPassword() {    //从当前视图获取密码
        return password.getText().toString().trim();
    }

    @Override
    public String getAddress() {     //从当前视图获取地址
        return address.getText().toString().trim();
    }

    @Override
    public String getMobile() {
        return mobile.getText().toString().trim();
    }

    @Override
    public String getBirth() {   //从当前视图获取出生日期
        return birth.getText().toString().trim();
    }

    @Override
    public String getEmail() {     //从当前视图获取电子邮箱地址
        return email.getText().toString().trim();
    }

    public void uploadImage(List<Bitmap> images) {       //图片压缩上传方法
        ImageCompress compress = new ImageCompress();
        compress.Compress(images, this, "http://116.62.23.56/slaver_demo2/images/");
        //TODO 需完成上传
    }

    @Override
    public String getHeadLink() {   //从当前视图获取头像（位图文件）

        String head = null;
        try {
            Bitmap bitmap = ((BitmapDrawable) headLink.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(baos);
            gzip.close();
            head = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, baos);
            int len = head.length();
            System.out.println("长度为：" + len);
            System.out.println("编码为：" + head);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Bitmap bitmap = ((BitmapDrawable) picture.getDrawable()).getBitmap();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();//将Bitmap转成Byte[]
//        bitmap.compress(Bitmap.CompressFormat.PNG, 50, baos);//压缩
//        head_src = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);//加密转换成String
//        int n = head_src.length();
//        System.out.println(head_src);   //图片压缩编码
        return head;
    }

    @Override
    public void showSuccessMsg() {      //显示注册成功的消息
        Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);  //启动登录功能页
    }

    @Override
    public void showFailMsg() {    //显示注册失败的消息
        Toast.makeText(this, "注册失败，该用户已存在！", Toast.LENGTH_SHORT).show();
    }


    protected void showChoosePicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("更换头像");
        String[] items = {"选择本地图片", "拍照"};
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        System.out.println("选择相片1");
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PHOTO: // 拍照
                        System.out.println("拍照启动1");
                        File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                        try {
                            if(outputImage.exists() ) {
                                outputImage.delete();
                            }
                            outputImage.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(Build.VERSION.SDK_INT >= 24) {
                            imageUri = FileProvider.getUriForFile(RegisterActivity.this,
                                    "com.yuntang.juney.demoone.fileprovider", outputImage);
                        } else {
                            imageUri = Uri.fromFile(outputImage);
                        }
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                        startActivityForResult(intent, TAKE_PHOTO);
                        break;
                }
            }
        });
        builder.create().show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if( resultCode == RESULT_OK ) {
                    System.out.println("拍照启动2");
                    try{
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        Glide.with(this).load(bitmap).into(headLink);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CHOOSE_PICTURE:
                System.out.println("选择相片2");
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    String imagePath = null;
                    if (DocumentsContract.isDocumentUri(this, uri)) {
                        String docId = DocumentsContract.getDocumentId(uri);
                        if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                            String id = docId.split(":")[1];
                            String selection = MediaStore.Images.Media._ID + "=" + id;
                            imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI ,selection);
                        } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                            Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                            imagePath = getImagePath(contentUri, null);
                        }
                    } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                        imagePath = getImagePath(uri , null);
                    } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                        imagePath = uri.getPath();
                    }
                    System.out.println("imagePath="+imagePath);
                    displayImage(imagePath);
                }
                break;
            default:
                break;
        }
    }


    private String getImagePath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        System.out.println("path="+path);
        return path;
    }

    private void displayImage(String imagePath) {
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            System.out.println(bitmap);
            Glide.with(this).load(bitmap).into(headLink);
            //FIXME 图片显示白屏
        } else {
            return;
        }
    }
}
