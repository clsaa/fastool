package com.echoclsaa.fastool.basic.concurrent;

public final class InternalFutures {
    public static Throwable tryInternalFastPathGetFailure(InternalFutureFailureAccess future) {
        return future.tryInternalFastPathGetFailure();
    }

    private InternalFutures() {
    }
}