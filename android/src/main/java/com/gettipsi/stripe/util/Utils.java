package com.gettipsi.stripe.util;

import com.stripe.android.model.Card;

/**
 * Created by dmitriy on 11/25/16
 */

public class Utils {

    public static String validateCard(final Card card) {
        if (!card.validateNumber()) {
            return "The card number that you entered is invalid";
        } else if (!card.validateExpiryDate()) {
            return "The expiration date that you entered is invalid";
        } else if (!card.validateCVC()) {
            return "The CVC code that you entered is invalid";
        } else if (!validateZip(card)) {
            return "The ZIP code that you entered is invalid  ";
        }

        return null;
    }

        public static boolean validateZip(final Card card) {
            String zip = card.getAddressZip();
            return zip.matches("^([0-9]{5}|[a-zA-Z][0-9][a-zA-Z] ?[0-9][A-Za-z][0-9])$");
        }


}
