// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.
package com.mojang.datafixers.types.constant;

import com.mojang.datafixers.util.Pair;
import com.mojang.datafixers.types.DynamicOps;
import com.mojang.datafixers.types.templates.Const;

import java.util.Optional;

public final class ShortType extends Const.ConstType<Short> {
    @Override
    public <T> Pair<T, Optional<Short>> read(final DynamicOps<T> ops, final T input) {
        return ops
            .getNumberValue(input)
            .map(v -> Pair.of(ops.empty(), Optional.of(v.shortValue())))
            .orElseGet(() -> Pair.of(input, Optional.empty()));
    }

    @Override
    public <T> T write(final DynamicOps<T> ops, final T rest, final Short value) {
        return ops.createShort(value);
    }

    @Override
    public String toString() {
        return "Short";
    }
}
