package proxypattern.reflectproxy;

/**
 * 顾客不可以改变自己的hotorNot评分
 * 也不可以改变其他人的信息
 * */
public class PersonBeanImpl implements PersonBean{
    String name, gender, interests;
    int rating, ratingCount = 0;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) return 0;
        return (rating/ratingCount);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating+= rating;
        ratingCount++;
    }
}
