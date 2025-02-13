package bean;

import java.io.Serializable;

public class CharacterBean implements Serializable {

    private int charaId;
    private String charaName;
    private String charaIcon;  // 修正: フィールド名を統一

    // ゲッター・セッター
    public int getCharaId() { return charaId; }
    public void setCharaId(int charaId) { this.charaId = charaId; }

    public String getCharaName() { return charaName; }
    public void setCharaName(String charaName) { this.charaName = charaName; }

    public String getCharaIcon() { return charaIcon; } // 修正
    public void setCharaIcon(String charaIcon) { this.charaIcon = charaIcon; } // 修正
}
