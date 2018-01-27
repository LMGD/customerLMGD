<script>
    //给来跳页码的
    function skipPage(){
        var curPage= document.getElementById('skipPage').value;
        location.href='doPage?curPage='+curPage;
    }
</script>
