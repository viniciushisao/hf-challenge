package br.com.hisao.hf.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receipe {

    private String calories;
    private String carbos;
    private String card;
    private String country;
    private List<String> deliverableIngredients = null;
    private String description;
    private Integer difficulty;
    private String fats;
    private Integer favorites;
    private String fibers;
    private String headline;
    private Boolean highlighted;
    private String id;
    private String image;
    private Object incompatibilities;
    private List<String> ingredients = null;
    private List<String> keywords = null;
    private String name;
    private List<String> products = null;
    private String proteins;
    private Double rating;
    private Integer ratings;
    private String thumb;
    private String time;
    private List<Object> undeliverableIngredients = null;
    private User user;
    private List<String> weeks = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCarbos() {
        return carbos;
    }

    public void setCarbos(String carbos) {
        this.carbos = carbos;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getDeliverableIngredients() {
        return deliverableIngredients;
    }

    public void setDeliverableIngredients(List<String> deliverableIngredients) {
        this.deliverableIngredients = deliverableIngredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    public String getFibers() {
        return fibers;
    }

    public void setFibers(String fibers) {
        this.fibers = fibers;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public Boolean getHighlighted() {
        return highlighted;
    }

    public void setHighlighted(Boolean highlighted) {
        this.highlighted = highlighted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getIncompatibilities() {
        return incompatibilities;
    }

    public void setIncompatibilities(Object incompatibilities) {
        this.incompatibilities = incompatibilities;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Object> getUndeliverableIngredients() {
        return undeliverableIngredients;
    }

    public void setUndeliverableIngredients(List<Object> undeliverableIngredients) {
        this.undeliverableIngredients = undeliverableIngredients;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<String> weeks) {
        this.weeks = weeks;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}