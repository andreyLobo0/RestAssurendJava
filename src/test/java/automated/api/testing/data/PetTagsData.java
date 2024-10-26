package automated.api.testing.data;

public class PetTagsData {
    private Long id;
    private String name;

    public PetTagsData() {
    }

    public PetTagsData(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PetTagsBuilder builder() {
        return new PetTagsBuilder();
    }

    public static class PetTagsBuilder {
        private Long id;
        private String name;

        public PetTagsBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public PetTagsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PetTagsData build() {
            return new PetTagsData(id, name);
        }
    }
}
