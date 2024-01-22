package org.me.javastudy.observerpattern.example;


public class Health {

    private Integer currentHealth;
    private Integer maxHealth;

    public Health(Health otherHealth) {
        this.currentHealth = otherHealth.getCurrentHealth();
        this.maxHealth = otherHealth.getMaxHealth();
    }

    public Health() {
    }

    public Health(Integer currentHealth, Integer maxHealth) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(Integer currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Health)) return false;
        Health health = (Health) o;
        return this.currentHealth.intValue() == health.getCurrentHealth().intValue()
                && this.maxHealth.intValue() == health.getMaxHealth().intValue();
    }

    @Override
    public String toString() {
        return "Health{" +
                "currentHealth=" + currentHealth +
                ", maxHealth=" + maxHealth +
                '}';
    }
}
