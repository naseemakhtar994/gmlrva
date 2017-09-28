/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.AllArgsConstructor;

/**
 * Magic Constant Annotation Enum containing the possible {@link GenericPayload} change key options.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor class GenericPayload {

    /* Constants */

    /** UPDATE_ITEM representing an item that needs to be updated. */
    static final String UPDATE_ITEM = "UPDATE_ITEM";

    // Declare the @StringDef for these constants
    @StringDef({ UPDATE_ITEM })
    @Retention(RetentionPolicy.SOURCE)
    public @interface GenericPayloadConstants { /* Do nothing here ... */ }

}
