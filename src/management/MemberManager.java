package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

import java.util.NoSuchElementException;

public class MemberManager {
    private CustomHashMap<String, Member> members;

    public MemberManager() {
        members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = members.get(memberId);
        if (member != null) {
            member.addTransaction(transaction);
        }
    }

    public Transaction getLastTransaction(String memberId) {
        Member member = members.get(memberId);
        if(member == null){
            throw new NoSuchElementException("This member Doesn't exist in the library");
        }
        return member.getLastTransaction();
    }
}
