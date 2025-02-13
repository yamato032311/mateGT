package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CharacterBean;

public class CharacterDao extends Dao{

    // 全件取得メソッド
    public List<CharacterBean> getAllCharacters() throws Exception {
        List<CharacterBean> characterList = new ArrayList<>();
        String sql = "SELECT * FROM t010_chara";  // テーブル名は適宜変更してください

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // 結果セットを処理
            while (rs.next()) {
                CharacterBean character = new CharacterBean();
                character.setCharaId(rs.getInt("chara_Id"));
                character.setCharaName(rs.getString("chara_Name"));
                character.setCharaIcon(rs.getString("chara_icon"));
                characterList.add(character);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // エラーハンドリング
        }

        return characterList;
    }


        public CharacterBean getCharacter(int charaId) throws Exception {
            String sql = "SELECT * FROM t010_chara WHERE chara_id = ?";  // テーブル名は適宜変更してください
            CharacterBean character = null;

            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, charaId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {  // while ではなく if に変更
                        character = new CharacterBean();
                        character.setCharaId(rs.getInt("chara_id"));
                        character.setCharaName(rs.getString("chara_name"));
                        character.setCharaIcon(rs.getString("chara_icon"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // ログ出力
            }

            return character; // データがなければ null を返す
        }

}




