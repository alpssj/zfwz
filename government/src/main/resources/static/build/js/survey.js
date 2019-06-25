(function(e) {
	if (!e) {return false;}
	var survey =  {
		NewQuestionId : {
			order: 0,              //题目位置
			titleNum: 0,           //题目编码  若没有题目，编码则和前一题编码一样
			absoluteId: 0,         //初始位置
			hasTitle: true,        //是否有题目
			type : 0,			   //问卷类型 1单选、2多选、3多行填空、4描述说明
			idNum: 0               //共添加题目的个数
		},

		choiceText: '',

		questionHtml : function() {
			var num,titText,qusChooseText,classN2,
				or = this.NewQuestionId.order,
				tit = this.NewQuestionId.titleNum,
				abs = this.NewQuestionId.absoluteId,
				hat = this.NewQuestionId.hasTitle,
				ty = this.NewQuestionId.type,

			    num = hat ? tit : '';

			    requ = '';
			    this.NewQuestionId.idNum++;

				this.choiceText = '				<div class="choice-text edit-area" contenteditable="true">选项 ';
        		this.choiceText +='					<ul class="edit-img" contenteditable="false">';
	        	this.choiceText +='						<li class="moveup-choice"><i class="fa fa-long-arrow-up"></i></li>';
	        	this.choiceText +='						<li class="movedown-choice"><i class="fa fa-long-arrow-down"></i></li>';
	        	this.choiceText +='						<li class="delete-choice"><i class="fa fa-trash"></i></li>';
	        	this.choiceText +='					</ul>';
        		this.choiceText +='				</div>';

			if(ty ==1) {
				classN2 = "ques-block";
				titText = '单选题';
				qusChooseText = '      <ul class="question-choice">';
        		qusChooseText +='			<li class="choice">';
        		qusChooseText +='				<input type="radio" name = "radio'+this.NewQuestionId.idNum+'" id = "radio'+this.NewQuestionId.idNum+'" >';
        		qusChooseText +=				this.choiceText;
        		qusChooseText +='			</li>';
        		qusChooseText +='			<li class="choice">';
        		qusChooseText +='				<input type="radio" name = "radio'+this.NewQuestionId.idNum+'" id = "radio'+this.NewQuestionId.idNum+'" >';
        		qusChooseText +=				this.choiceText;
        		qusChooseText +='			</li>';
        		qusChooseText +='		</ul>';
        		qusChooseText +='       <div class="add-area"><i class="fa fa-plus-square-o"></i></div>      ';
			}
			else if(ty == 2) {
				classN2 = "ques-block";
				titText = '多选题';
				qusChooseText = '       <ul class="question-choice">';
        		qusChooseText +='			<li class="choice">';
        		qusChooseText +='				<input type="checkbox" name = "checkbox'+this.NewQuestionId.idNum+'" id = "checkbox'+this.NewQuestionId.idNum+'" >';
        		qusChooseText +=				this.choiceText;
        		qusChooseText +='			</li>';
        		qusChooseText +='			<li class="choice">';
        		qusChooseText +='				<input type="checkbox" name = "checkbox'+this.NewQuestionId.idNum+'" id = "checkbox'+this.NewQuestionId.idNum+'" >';
        		qusChooseText +=				this.choiceText;
        		qusChooseText +='			</li>';
        		qusChooseText +='		</ul>';
        		qusChooseText +='       <div class="add-area"><i class="fa fa-plus-square-o"></i></div>      ';
			}
			else if(ty == 3) {
				classN2 = "ques-block";
				titText = '多行填空题';
				qusChooseText = '      <ul class="question-choice">';
        		qusChooseText +='			<li>';
        		qusChooseText +='				<textarea class="multi-input" name="multi-input'+this.NewQuestionId.idNum+'" id="multi-input'+this.NewQuestionId.idNum+'"></textarea>';
        		qusChooseText +='			</li>';
        		qusChooseText +='		</ul>';
			}
			else if(ty == 4) {
				var classN = "describe";
				titText = '描述说明';
				qusChooseText  = '';
				requ = '';
			}

			var questionText = 				'	<div class="topic-type-question clearfix '+classN+'">';
        		questionText = questionText +'		<div class="question-title '+classN2+'"> ';
        		questionText = questionText +'			<span class="required">'+requ+'</span> ';
        		questionText = questionText +'			<span class="question-id" _order = "'+or+'" _titleNum = "'+tit+'" _absoluteId = "'+abs+'" _hasTitle = '+hat+'>'+num+'</span> ';
        		questionText = questionText +'			<div class="qu-title-content edit-area " contenteditable="true">'+titText+'</div> ';
        		questionText = questionText +'		</div>' ;
        		questionText = questionText +       qusChooseText ;
        		questionText = questionText +'      <ul class=" operate ">' ;
				questionText = questionText +'			<li class = "move-up"><i class="fa fa-long-arrow-up"></i></li>' ;
				questionText = questionText +'			<li class = "move-down"><i class="fa fa-long-arrow-down"></i></li>' ;
				questionText = questionText +'			<li class="delete"><i class="fa fa-trash"></i></li>' ;
				questionText = questionText +'		</ul>' ;
				questionText = questionText +'	</div>' ;

			return questionText;
		},

		// changeNum : function (questionId) {  //修改问题编号
		// 	if (plus) {
		// 		this.questionId.order += questionId.order;
		// 	}
		// },

		addQuestion : function() {
			var _this = this;
			$(".navul-left").delegate("li", "click", function() {
				var t = $(this).attr("_type");
				var len = $(".question-box").find(".topic-type-question").length;
				var titN = $($(".question-box").find(".topic-type-question").find(".question-id")[len-1]).attr("_titleNum");

				_this.NewQuestionId.type = t;
				_this.NewQuestionId.order = len +1;
				_this.NewQuestionId.absoluteId = len +1;
				if (t != 4) {
					_this.NewQuestionId.hasTitle = true;
					_this.NewQuestionId.titleNum = titN? parseInt(titN) +1 : 1;
				}
				else {
					_this.NewQuestionId.hasTitle = false;
					_this.NewQuestionId.titleNum = titN? parseInt(titN) : 0;
				}

				var html = _this.questionHtml();
				if (_this.NewQuestionId.order == 1) { //如果之前没有添加问题
					$(".question-box").html(html);
				}
				else {
					$(".question-box").append(html);
				}
			})
		},


		deleteQuestion : function() {
			$(".question-box").delegate(".topic-type-question .operate .delete", "click", function () {
				var parentNode = $(this).parent(".operate").parent(".topic-type-question");
				var qusOrder = parentNode.find(".question-id").attr("_order");
				var qushas = parentNode.find(".question-id").attr("_hastitle");
 				var len = $(".question-box").find(".topic-type-question").length;

				for (var i = len - 1; i >= parseInt(qusOrder) ; i--) {
					var o = parseInt($($(".question-id")[i]).attr("_order"))-1;
					$($(".question-id")[i]).attr("_order", o);
					if (qushas == "true") {
						var tit = parseInt($($(".question-id")[i]).attr("_titleNum"))-1;
						$($(".question-id")[i]).attr("_titleNum", tit);
						if ($($(".question-id")[i]).text()) {
							$($(".question-id")[i]).text(tit);	
						}
					}
				}
				parentNode.remove();
			})
		},

		addChoice : function() {
			var _this = this;
			$(".question-box").delegate(".topic-type-question .add-area", "click", function() {
				var choiceNode = $(this).prev("ul");
				var inputText = choiceNode.find("input").prop("outerHTML");
				var choiceNodeText ='<li class="choice">' + inputText + _this.choiceText + '	</li>';
				choiceNode.append(choiceNodeText);
			})
		},

		deleteChoice: function() {
			$(".question-box").delegate(".topic-type-question .question-choice .choice .choice-text .edit-img .delete-choice", "click", function() {
				$(this).parent("ul").parent(".choice-text").parent("li").remove();
			})
		},

		moveQuestion: function(ele, tp) {
				var parentNode, 
					annexActiveNode, 
					selfqusOrder,
					annexqusOrder, 
					annexqusNode, 
					selfRunNum, 
					annexRunNum ,
					annexorderNum , 
					selfqushas, 
					selfqusNode, 
					annexqushas,
					selfqusTnum,
					annexqusTnum,
					len;

				parentNode = ele.parent(".operate").parent(".topic-type-question");
				selfqusOrder = parseInt(parentNode.find(".question-id").attr("_order"));
				len = $(".question-box").find(".topic-type-question").length;

				if ((tp == 'up') && (selfqusOrder > 1)) {  //问题上移
					annexActiveNode = parentNode.prev(".topic-type-question");    //前一个问题
					selfRunNum = -1;
					annexRunNum = 1;
				}
				else if ((tp == 'down') && (selfqusOrder < len)) {   //问题下移
					annexActiveNode = parentNode.next(".topic-type-question");            //后一个问题
					selfRunNum = 1;
					annexRunNum = -1;
					// $(annexActiveNode).insertBefore(parentNode);
				}
				else {
					return false;
				}

				annexqusNode = annexActiveNode.find(".question-id");
				selfqusNode = parentNode.find(".question-id");
				annexqusOrder = parseInt(annexqusNode.attr("_order"));
				selfqushas = selfqusNode.attr("_hastitle");         //当前问题是否存在标题
				annexqushas = annexqusNode.attr("_hastitle");            //关联移动问题是否存在标题
				selfqusTnum = selfqusNode.attr("_titleNum");        
				annexqusTnum = annexqusNode.attr("_titleNum");           
				
				selfqusNode.attr("_order", selfqusOrder+selfRunNum );    //设置移动问题的order
				annexqusNode.attr("_order", annexqusOrder+annexRunNum );   //设置关联移动问题的order

				var a = parseInt(selfqusTnum)+parseInt(selfRunNum);
				var b = parseInt(annexqusTnum)+parseInt(annexRunNum);
				if (selfqushas == 'true' && annexqushas == 'true') {
					selfqusNode.attr("_titlenum", a );    
					annexqusNode.attr("_titlenum", b ); 
					if (selfqusNode.text()) {
						selfqusNode.text(a);
					}
					if (annexqusNode.text()) {
						annexqusNode.text(b);
					}

				}
				else if (selfqushas == 'true' && annexqushas == 'false') {
					annexqusNode.attr("_titlenum", b );   
					if (annexqusNode.text()) {
						annexqusNode.text(b);
					}
				}
				else if (selfqushas == 'false' && annexqushas == 'true') {
					selfqusNode.attr("_titlenum", a );   
					if (selfqusNode.text()) {
						selfqusNode.text(a);
					} 
					 
				}
				else if (selfqushas == 'false' && annexqushas == 'false') {
					// selfqusNode.attr("_titlenum", selfqusTnum );    
					// annexqusNode.attr("_titlenum", annexqusTnum );   
				}

				if (selfRunNum < 0) {
					$(parentNode).insertBefore(annexActiveNode);
				}
				else {
					$(annexActiveNode).insertBefore(parentNode);
				}

		},

		addMove: function() {
			var _this = this;
			$(".question-box").delegate(".topic-type-question .operate .move-up", "click", function () {
				_this.moveQuestion($(this), 'up');
			});
			$(".question-box").delegate(".topic-type-question .operate .move-down", "click", function () {
				_this.moveQuestion($(this), 'down');
			});
		},

		moveUpChioce: function() {
			$(".question-box").delegate(".topic-type-question .question-choice .choice .choice-text .edit-img .moveup-choice", "click", function() {
				var parentN = $(this).parent("ul").parent(".choice-text").parent("li");
				var prevNode = parentN.prev() ? parentN.prev() : false;
				if (prevNode) {
					$(parentN).insertBefore(prevNode);
				}
			})
		},

		moveDownChioce: function() {
			$(".question-box").delegate(".topic-type-question .question-choice .choice .choice-text .edit-img .movedown-choice", "click", function() {
				var parentN = $(this).parent("ul").parent(".choice-text").parent("li");
				var nextNode = parentN.next() ? parentN.next() : false;
				if (nextNode) {
					$(nextNode).insertBefore(parentN);
				}
			})
		},

		previewSurvey: function() {
			$("#preview-survey").click(function(){
				var surveyHtml = $("#sur-container").prop("outerHTML");
				localStorage.setItem('surveyHtml', surveyHtml);
				window.open("questionnaire.html");
			})
		}

	}

	survey.addQuestion();
	survey.deleteQuestion();
	survey.addMove();
	survey.moveUpChioce();
	survey.moveDownChioce();
	survey.deleteChoice();
	survey.addChoice();
	survey.previewSurvey();

})(window.jQuery)