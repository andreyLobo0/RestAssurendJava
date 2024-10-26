package automated.api.testing.data;

public class PetCategoryData {
    private Long id;
    private String name;

    public PetCategoryData() {
    }

    public PetCategoryData(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static PetCategoryBuilder builder() {
        return new PetCategoryBuilder();
    }

    public static class PetCategoryBuilder {
        private Long id;
        private String name;

        public PetCategoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PetCategoryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PetCategoryData build() {
            return new PetCategoryData(id, name);
        }
    }
}
