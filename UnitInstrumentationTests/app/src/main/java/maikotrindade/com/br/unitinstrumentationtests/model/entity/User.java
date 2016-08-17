package maikotrindade.com.br.unitinstrumentationtests.model.entity;

import java.util.Date;

/**
 * Created by adenilson on 11/08/16.
 */
public class User {
    private String login;
    private Long id;
    private String avatarURL;
    private String url;
    private String name;
    private Long followers;
    private Date createDate;
    private Date updateDate;

    public User(){}

    public User(String login, Long id, String avatarURL, String url, String name, Long followers,
                Date createDate, Date updateDate) {
        this.login = login;
        this.id = id;
        this.avatarURL = avatarURL;
        this.url = url;
        this.name = name;
        this.followers = followers;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
