package es.upm.miw.apaw_practice.domain.models.bakery;

public class ProductType {
    private String name;
    private String description;
    private String code;

    public ProductType() {
        // empty for framework
    }

    public ProductType(String name, String description, String code) {
        this.name = name;
        this.description = description;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", code='" + getCode() + "'" +
                "}";
    }

    // Builder Pattern

    public static ProductTypeBuilder.Name builder(String name) {
        return new ProductType.Builder();
    }

    private interface ProductTypeBuilder {
        interface Name {
            Description name(String name);
        }

        interface Description {
            Code description(String description);
        }

        interface Code {
            Code code(String code);

            ProductType build();
        }
    }

    public static class Builder
            implements ProductTypeBuilder.Name, ProductTypeBuilder.Description, ProductTypeBuilder.Code {
        private final ProductType productType;

        public Builder() {
            this.productType = new ProductType();
        }

        @Override
        public ProductTypeBuilder.Description name(String name) {
            this.productType.setName(name);
            return this;
        }

        @Override
        public ProductTypeBuilder.Code description(String description) {
            this.productType.setDescription(description);
            return this;
        }

        @Override
        public ProductTypeBuilder.Code code(String code) {
            this.productType.setCode(code);
            return this;
        }

        @Override
        public ProductType build() {
            return this.productType;
        }
    }
}
