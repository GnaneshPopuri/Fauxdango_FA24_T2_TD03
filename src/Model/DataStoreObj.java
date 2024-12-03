package Model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public abstract class DataStoreObj {
    private static final AtomicLong nextPK = new AtomicLong(Long.MAX_VALUE);
    private final long pk;

    public long getPrimaryKey() {
        return pk;
    }

    private Long nextPK() {
        return nextPK.getAndDecrement();
    }

    public DataStoreObj() {
        pk = nextPK();
    }

    public DataStoreObj(Long id) {
        this.pk = Objects.requireNonNullElseGet(id, this::nextPK);
    }
}
