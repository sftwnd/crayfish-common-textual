package com.github.sftwnd.crayfish.common.textual;

import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

/**
 *  Naming convention in which a name contains multiple words that are joined together as a single word.
 *  In terms of capitalization, the first word is always all lowercase letters, including the first letter.
 */
public class CamelCase {

    /**
     * Create camelCase notation from the set of words where tag dividers are upper-case symbol or start of the work
     * @param text parsed text
     * @return camelCase notation
     */
    public static String camelCase(@NonNull String text) {
        if (text.isBlank()) {
            return "";
        } else if (Character.isSpaceChar(text.charAt(0))) {
            return camelCase(text.trim());
        } else {
            for (int i = 1; i < text.length(); i++) {
                if (Character.isUpperCase(text.charAt(i)) || Character.isSpaceChar(text.charAt(i))) {
                    return Character.toUpperCase(text.charAt(0)) +
                            (i == 1 ? "" : text.substring(1, i)) +
                            camelCase(text.substring(i).trim());
                }
            }
            return Character.toUpperCase(text.charAt(0)) + text.substring(1);
        }
    }

    /**
     * Convert CamelCase notation first symbol to lowercase
     * @param text text to convert
     * @return converted text
     */
    @NonNull
    public static String lowerCamelCase(@NonNull String text) {
        return text.isBlank() ? "" : Character.toLowerCase(text.charAt(0)) + text.substring(1);
    }

    /**
     * Convert result fo CamelCase notation Supplier result first symbol to lowercase
     * @param camelCaseSupplier supplier to construct text for conversion
     * @return converted text
     */
    @Nullable
    public static String lowerCamelCase(@Nullable Supplier<String> camelCaseSupplier) {
        return Optional.ofNullable(camelCaseSupplier)
                .map(Supplier::get)
                .map(CamelCase::lowerCamelCase)
                .orElse(null);
    }

    /**
     * Convert CamelCase notation first symbol to uppercase
     * @param text text to convert
     * @return converted text
     */
    @NonNull
    public static String upperCamelCase(@NonNull String text) {
        return text.isBlank() ? "" : Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }

    /**
     * Convert result fo CamelCase notation Supplier result first symbol to uppercase
     * @param camelCaseSupplier supplier to construct text for conversion
     * @return converted text
     */
    @Nullable
    public static String upperCamelCase(@Nullable Supplier<String> camelCaseSupplier) {
        return Optional.ofNullable(camelCaseSupplier)
                .map(Supplier::get)
                .map(CamelCase::upperCamelCase)
                .orElse(null);
    }

    private CamelCase() {
    }

}
