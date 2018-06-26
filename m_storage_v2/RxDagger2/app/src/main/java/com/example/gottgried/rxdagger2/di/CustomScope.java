package com.example.gottgried.rxdagger2.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Gottgried on 10.06.2018.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {
}
