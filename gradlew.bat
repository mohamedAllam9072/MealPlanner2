<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/gray"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize">

        <com.google.android.material.floatingactionbutton.FloatingActionButton
            android:id="@+id/fab1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="@dimen/val_8dp" />

        <TextView
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_margin="@dimen/val_8dp"
            android:layout_weight="1"
            android:gravity="center_vertical"
            android:text="Blood Bank"
            android:textAppearance="@style/TextAppearance.AppCompat.Large"
            android:textStyle="bold" />


    </LinearLayout>

    <androidx.core.widget.NestedScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <androidx.recyclerview.widget.RecyclerView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                tools:itemCount="3"
                android:layout_margin="@dimen/val_8dp"
                android:orientation="horizontal"
                tools:listitem="@layout/item_rv_asap" />

            <androidx.cardview.widget.CardView
                android:id="@+id/card"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="@dimen/val_8dp"
                app:cardCornerRadius="@dimen/val_16dp"
                app:cardPreventCornerOverlap="true">

                <an