package automated.api.testing.data;

import java.util.List;

public class PetData {
    private Long id;
    private PetCategoryData category;
    private String name;
    private List<String> photoUrls;
    private List<PetTagsData> tags;
    private String status;

    public PetData() {
    }

    public PetData(Long id, PetCategoryData category, String name, List<String> photoUrls, List<PetTagsData> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public PetCategoryData getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<PetTagsData> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(PetCategoryData category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(List<PetTagsData> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static PetBuilder builder() {
        return new PetBuilder();
    }

    public static class PetBuilder {
        private Long id;
        private PetCategoryData category;
        private String name;
        private List<String> photoUrls;
        private List<PetTagsData> tags;
        private String status;

        public PetBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PetBuilder category(PetCategoryData category) {
            this.category = category;
            return this;
        }

        public PetBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder photoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls;
            return this;
        }

        public PetBuilder tags(List<PetTagsData> tags) {
            this.tags = tags;
            return this;
        }

        public PetBuilder status(String status) {
            this.status = status;
            return this;
        }

        public PetData build() {
            return new PetData(id, category, name, photoUrls, tags, status);
        }
    }
}
