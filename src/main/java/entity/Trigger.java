package entity;

import enums.TriggeType;

public class Trigger {
    private long userId;
    private TriggeType triggerType = TriggeType.NONE;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public TriggeType getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(TriggeType triggerType) {
        this.triggerType = triggerType;
    }


}
