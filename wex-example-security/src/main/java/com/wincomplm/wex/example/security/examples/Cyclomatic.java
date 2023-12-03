/*
 * Copyright (c) 2022 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */

package com.wincomplm.wex.example.security.examples;

/**
 *
 * @author SimonHeath
 */
public class Cyclomatic {

    void bad() {
        if (true) {
            if (true) {
                if (true) {
                    if (true) {
                        if (true) {
                            if (true) {
//                                if (true) {
//                                    if (true) {
//                                        if (true) {
//                                        }
//                                    }
//                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
